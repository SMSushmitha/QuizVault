import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.util.concurrent.Executors;

/**
 * QuizVault - Simple Java HTTP Server
 * Serves the frontend files for the Online Quiz/Exam Portal.
 *
 * How to Run:
 *   1. Place this file in the quiz-portal/ directory
 *   2. Compile: javac QuizServer.java
 *   3. Run:     java QuizServer
 *   4. Open browser: http://localhost:8080
 *
 * @author  [Your Name]
 * @version 1.0
 */
public class QuizServer {

    private static final int PORT = 8080;
    private static final String FRONTEND_DIR = "frontend";

    public static void main(String[] args) throws IOException {
        // Create HTTP server on the given port
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // Route all requests to our file handler
        server.createContext("/", new StaticFileHandler());

        // Use a thread pool so multiple requests can be served
        server.setExecutor(Executors.newFixedThreadPool(4));
        server.start();

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      QuizVault Server Started!       ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  URL : http://localhost:" + PORT + "          ║");
        System.out.println("║  Dir : " + FRONTEND_DIR + "/                  ║");
        System.out.println("║  Press Ctrl+C to stop the server.    ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    /**
     * Handles HTTP GET requests and serves static files.
     */
    static class StaticFileHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestMethod = exchange.getRequestMethod();

            // Only handle GET requests
            if (!requestMethod.equalsIgnoreCase("GET")) {
                sendResponse(exchange, 405, "text/plain", "Method Not Allowed");
                return;
            }

            // Get the requested path
            String requestPath = exchange.getRequestURI().getPath();

            // Default to index.html
            if (requestPath.equals("/")) {
                requestPath = "/index.html";
            }

            // Build the file path
            File file = new File(FRONTEND_DIR + requestPath);

            // Check if file exists
            if (!file.exists() || file.isDirectory()) {
                sendResponse(exchange, 404, "text/html",
                    "<h2>404 - Page Not Found</h2><p><a href='/'>Go to Home</a></p>");
                return;
            }

            // Determine content type
            String contentType = getContentType(requestPath);

            // Read and send the file
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(200, fileBytes.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(fileBytes);
            }

            System.out.println("[GET] " + requestPath + " → 200 OK");
        }

        /**
         * Returns the MIME type based on file extension.
         */
        private String getContentType(String path) {
            if (path.endsWith(".html")) return "text/html; charset=utf-8";
            if (path.endsWith(".css"))  return "text/css";
            if (path.endsWith(".js"))   return "application/javascript";
            if (path.endsWith(".json")) return "application/json";
            if (path.endsWith(".png"))  return "image/png";
            if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return "image/jpeg";
            if (path.endsWith(".svg"))  return "image/svg+xml";
            if (path.endsWith(".ico"))  return "image/x-icon";
            return "text/plain";
        }

        /**
         * Sends a simple text/HTML response.
         */
        private void sendResponse(HttpExchange exchange, int statusCode,
                                   String contentType, String body) throws IOException {
            byte[] bytes = body.getBytes();
            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(statusCode, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }
}

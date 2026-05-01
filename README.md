# 🎯 QuizVault – Online Exam Portal

A full-stack Online Quiz/Exam Portal built with **Java** (backend) and **HTML/CSS/JavaScript** (frontend). Designed as a placement project for final year students.

---

## 🚀 Features

- 🔐 **Student Login** — Name, Roll Number & Subject selection
- 📝 **MCQ Quiz** — 10 questions per subject with 15-minute timer
- 🗂️ **5 Subjects** — Java, Web Development, DBMS, OS, Computer Networks
- ⏱️ **Auto Submit** — Exam submits automatically when time runs out
- 📊 **Result Dashboard** — Grade, score, time taken, full answer review
- 🎉 **Confetti Animation** — Celebrates when you pass!
- ☕ **Java HTTP Server** — Pure Java backend (no frameworks needed)

---

## 🛠️ Tech Stack

| Layer    | Technology                    |
|----------|-------------------------------|
| Frontend | HTML5, CSS3, Vanilla JS       |
| Backend  | Java (HttpServer – built-in)  |
| Storage  | Browser SessionStorage        |
| Fonts    | Google Fonts (Syne + DM Sans) |

---

## 📁 Project Structure

```
quiz-portal/
├── QuizServer.java        ← Java backend server
├── README.md
└── frontend/
    ├── index.html         ← Login page
    ├── quiz.html          ← Exam page (MCQ + Timer)
    └── result.html        ← Result & Review page
```

---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or higher installed
- A web browser

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/quiz-vault.git
cd quiz-vault

# 2. Compile the Java server
javac QuizServer.java

# 3. Run the server
java QuizServer

# 4. Open browser
# Go to: http://localhost:8080
```

> ✅ No Maven, no Spring Boot, no extra libraries needed!

---

## 🧪 How to Use

1. Open `http://localhost:8080`
2. Enter your **Name** and **Roll Number**
3. Select a **Subject**
4. Click **Start Exam**
5. Answer 10 MCQs within **15 minutes**
6. Click **Submit Exam** or wait for auto-submit
7. View your **Result & Grade**

---

## 📊 Grading System

| Score  | Grade | Remark         |
|--------|-------|----------------|
| 90–100%| A+    | Outstanding    |
| 75–89% | A     | Excellent      |
| 60–74% | B     | Good           |
| 40–59% | C     | Needs Practice |
| 0–39%  | F     | Keep Trying    |

---

## 💡 Future Enhancements

- [ ] Admin panel to add/edit questions
- [ ] MySQL database integration
- [ ] User authentication with password
- [ ] Leaderboard / ranking system
- [ ] PDF result download

---
## What I Learned
- Understanding real-world project structure  
- How different files are connected  
- Improving debugging and reading code skills

  ## Acknowledgement
This project is based on an existing implementation and was used for learning purposes.

## 👨‍💻 Author

S M Sushmitha 
Final Year Student – RYM engineering college
https://github.com/SMSushmitha


---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

# Java Spring Boot Integration with DeepSeek AI

## 📌 Overview
This project demonstrates how to integrate **DeepSeek AI** into a **Java Spring Boot** application for building intelligent, AI-powered features such as natural language processing, code generation, and content summarization.

The tutorial walks you through setting up your Spring Boot backend, connecting to the DeepSeek API, and handling requests/responses efficiently.

---

## 🚀 Features
- Spring Boot REST API integration with DeepSeek AI
- Secure API key management
- Example endpoint for text-based AI completion
- JSON request/response mapping
- Configurable prompt templates
- Easily extendable for multiple AI tasks

---

## 🛠️ Tech Stack
- **Java 17** (works with Java 11+)
- **Spring Boot 3.x**
- **Maven** for dependency management
- **DeepSeek AI API**
- **Lombok** for boilerplate reduction
- **Spring Web** for REST API

---

## 📂 Project Structure

src/
└── main/
├── java/
│ └── com.example.deepseek
│ ├── controller/ # API endpoints
│ ├── service/ # Business logic
│ ├── config/ # API key & client configuration
│ └── model/ # Request/response objects
└── resources/
└── application.yml # Configurations


---

## ⚙️ Setup & Installation

1️⃣ **Clone the repository**
```bash
git clone https://github.com/liyabonasaki/springboot-deepseek-ai.git
cd springboot-deepseek-ai 
```

2️⃣ **Configure DeepSeek API Key**

``
deepseek:
api-key: YOUR_DEEPSEEK_API_KEY
base-url: https://api.deepseek.com/v1
``

3️⃣ **Build & Run the Project**
```
mvn clean install
mvn spring-boot:run
```

4️⃣ **Test the API**
```
curl -X POST http://localhost:8080/api/ai/complete \
  -H "Content-Type: application/json" \
  -d '{"prompt": "Explain microservices in simple terms"}'
```





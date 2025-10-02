# Javocado 🍐

**Javocado** is a personal microservices-based system, created and maintained by **Xin Liu**, a senior backend engineer. It is designed both for **daily life enhancement** and for **deepening understanding of modern backend technologies**.

This is not a demo — it’s a real system to serve real needs. It will continue to grow as new modules and tech are added.

---

## 🚀 Vision

- 👩🏻‍💻 For **self-learning** — experiment with Spring Boot, REST, frontend/backend integration
- 🛠️ For **system design** — hands-on modular microservices architecture
- ❤️ For **real use** — manage stock, recipes, and eventually journals, expenses, and more

---

## 📦 Current Modules

| Module          | Description                                                                 |
|-----------------|-----------------------------------------------------------------------------|
| `portal-service`| The UI landing page — shows time, weather, and stock performance           |
| `stock-service` | REST API fetching YTD returns from CNBC for a list of stock tickers        |
| `recipe-service`| Coming soon — manage and search personal recipes (with photos and notes)   |

Each service is a Spring Boot 3.x application using **Java 17** and **Maven**.

---

## 🔧 Tech Stack

- Java 17
- Spring Boot 3.x
- Maven Multi-module structure
- Thymeleaf (frontend templates)
- RestTemplate (API calls)
- Jackson (JSON parsing)
- Modular REST APIs
- Future plans: Kafka, PostgreSQL, file upload, etc.

---

## 💻 How to Run

### Prerequisites

- JDK 17+
- Maven 3.8+

### Clone and Build

```bash
git clone https://github.com/your-username/javocado.git
cd javocado
# StyleFlow 👗

> A full-stack fashion e-commerce platform built with Spring Boot and Angular.

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.0-6DB33F?style=flat&logo=spring-boot&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-18-DD0031?style=flat&logo=angular&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)
![Status](https://img.shields.io/badge/status-in_progress-yellow?style=flat)

---

## 📋 Overview

StyleFlow is a modern fashion marketplace where users can browse products, manage their cart, place orders and receive real-time stock updates. Sellers can manage their catalogue and track orders through a dedicated dashboard.

> 🚧 **In progress** — StyleFlow is being built layer by layer, from a clean Spring Boot foundation toward the full platform described below.

---

## ✨ Features

- 🛍️ Product catalogue with filters (category, size, price, brand)
- 🛒 Cart management and order placement
- 📦 Order tracking and history
- 🔐 JWT authentication with role-based access control (USER / SELLER / ADMIN)
- 🔔 Real-time stock updates via WebSocket
- 📊 Admin dashboard for inventory and order management
- 🐳 Fully containerized with Docker Compose

---

## 🏗️ Architecture

```
styleflow/
├── backend/                  # Spring Boot application
│   ├── src/main/java/com/styleflow/
│   │   ├── entity/           # JPA entities
│   │   ├── repository/       # Spring Data JPA repositories
│   │   ├── service/          # Business logic
│   │   ├── controller/       # REST controllers, WebSocket handlers
│   │   └── exception/        # Custom exceptions + global handler
│   └── src/test/             # Unit & integration tests
├── frontend/                 # Angular application
│   └── src/app/
│       ├── core/             # Auth, guards, interceptors
│       ├── features/         # Product, cart, orders, dashboard
│       └── shared/           # Reusable components, pipes
└── docker-compose.yml
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 21, Spring Boot 4.1.0, Spring Security |
| Frontend | Angular 18, TypeScript, TailwindCSS |
| Database | PostgreSQL |
| Real-time | WebSocket (STOMP) |
| Auth | JWT + Refresh Tokens |
| DevOps | Docker, Docker Compose, CI/CD |
| Testing | JUnit 5, Mockito, Testcontainers |
| Quality | SonarQube, Checkstyle |

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Node.js 20+
- Docker & Docker Compose

### Run with Docker (planned setup)

> ⚠️ Docker Compose orchestration is on the roadmap — not yet available.

```bash
git clone https://github.com/Zakaria-Ar/styleflow.git
cd styleflow
docker-compose up --build
```

- Frontend: http://localhost:4200
- Backend API: http://localhost:8080
- API Docs (Swagger): http://localhost:8080/swagger-ui.html

### Run locally (planned setup)

> ⚠️ The frontend and full local orchestration are on the roadmap. The backend currently runs standalone with `./mvnw spring-boot:run` on port 8080.

```bash
# Backend
cd backend
./mvnw spring-boot:run

# Frontend
cd frontend
npm install
ng serve
```

---

## 🗺️ Roadmap

- [ ] Product catalogue & search
- [ ] Cart & checkout flow
- [ ] JWT auth + RBAC
- [ ] WebSocket real-time stock
- [ ] Seller dashboard
- [ ] Admin panel
- [ ] Docker Compose setup
- [ ] CI/CD pipeline
- [ ] Payment integration (Stripe)

---

## 📄 License

MIT License — see [LICENSE](LICENSE) for details.
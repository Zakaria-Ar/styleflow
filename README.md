# StyleFlow 👗

> A full-stack fashion e-commerce platform built with Spring Boot and Angular.

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=flat&logo=spring-boot&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-18-DD0031?style=flat&logo=angular&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)

---

## 📋 Overview

StyleFlow is a modern fashion marketplace where users can browse products, manage their cart, place orders and receive real-time stock updates. Sellers can manage their catalogue and track orders through a dedicated dashboard.

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
│   │   ├── domain/           # Entities, value objects (hexagonal core)
│   │   ├── application/      # Use cases / services
│   │   ├── infrastructure/   # Repos, external adapters
│   │   └── api/              # REST controllers, WebSocket handlers
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
| Backend | Java 17, Spring Boot 3, Spring Security |
| Frontend | Angular 18, TypeScript, TailwindCSS |
| Database | PostgreSQL |
| Real-time | WebSocket (STOMP) |
| Auth | JWT + Refresh Tokens |
| DevOps | Docker, Docker Compose, GitLab CI/CD |
| Testing | JUnit 5, Mockito, Testcontainers |
| Quality | SonarQube, Checkstyle |

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Node.js 20+
- Docker & Docker Compose

### Run with Docker (recommended)

```bash
git clone https://github.com/Zakaria-Ar/styleflow.git
cd styleflow
docker-compose up --build
```

- Frontend: http://localhost:4200
- Backend API: http://localhost:8080
- API Docs (Swagger): http://localhost:8080/swagger-ui.html

### Run locally

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

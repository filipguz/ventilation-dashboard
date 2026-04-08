# 🌬️ Ventilation Dashboard

A full-stack dashboard for monitoring and controlling a ventilation system (Östberg HERU) using Spring Boot, React, and Modbus TCP.

---

## 🚀 Overview

This project is a **home automation / IoT dashboard** that connects to a ventilation system and visualizes real-time data such as:

* Supply air temperature
* Extract air temperature
* Fan speed
* System mode

The architecture is designed to be scalable and production-ready.

---

## 🧠 Architecture

```
[ Ventilation System ]
          │
   (Modbus TCP / Ethernet)
          │
[ Spring Boot Backend ]
          │
     REST API (JSON)
          │
[ React Frontend Dashboard ]
```

---

## 🛠️ Tech Stack

### Backend

* Java 17
* Spring Boot 4
* Maven
* REST API

### Frontend

* React (Vite)
* JavaScript
* CSS (Matrix-inspired UI)

### Infrastructure

* Linux (Ubuntu)
* Raspberry Pi (planned)
* Modbus TCP (planned integration)

---

## 📦 Project Structure

```
ventilation-dashboard/
├── backend/         # Spring Boot API
├── frontend/        # React dashboard
├── docs/            # Documentation
└── README.md
```

---

## ⚙️ Backend Setup (Spring Boot)

### 1. Navigate to backend

```bash
cd backend
```

### 2. Run application

```bash
./mvnw spring-boot:run
```

### 3. API Endpoint

```
GET http://localhost:8080/api/ventilation/status
```

### Example response

```json
{
  "supplyTemp": 21.5,
  "extractTemp": 22.0,
  "fanSpeed": 70,
  "mode": "NORMAL"
}
```

---

## 🎨 Frontend Setup (React)

### 1. Navigate to frontend

```bash
cd frontend
```

### 2. Install dependencies

```bash
npm install
```

### 3. Start dev server

```bash
npm run dev
```

### 4. Open in browser

```
http://localhost:5173
```

---

## 🔄 Development Workflow

You need **two terminals running**:

### Terminal 1 (Backend)

```bash
cd backend
./mvnw spring-boot:run
```

### Terminal 2 (Frontend)

```bash
cd frontend
npm run dev
```

---

## 🌐 Networking Setup (Ventilation)

To connect the ventilation system:

1. Use a standard Ethernet cable (Cat5e or Cat6)

2. Connect ventilation unit to router/switch

3. Enable:

   * Modbus TCP
   * Port 502

4. Find device IP:

```bash
arp -a
```

or:

```bash
nmap 192.168.0.0/24
```

---

## 🔌 Modbus Integration (Planned)

Next step is to replace mock data with real data:

* Connect to Modbus TCP (port 502)
* Read registers from ventilation unit
* Map values to API

Example future endpoint:

```
GET /api/ventilation/status → real hardware data
```

---

## ⚠️ Safety Notes

* Always disconnect power before opening ventilation unit
* Do not modify internal wiring unless qualified
* Network connection (RJ45) is safe

---

## 🧪 Current Status

* ✅ Backend API working
* ✅ Frontend dashboard working
* ✅ Data flow (mock → UI)
* 🔜 Modbus integration
* 🔜 Raspberry Pi deployment
* 🔜 Real-time updates (WebSocket)

---

## 📈 Roadmap

* [ ] Modbus TCP integration
* [ ] Real sensor data
* [ ] Historical graphs
* [ ] WebSocket live updates
* [ ] Authentication (login)
* [ ] Mobile-friendly UI
* [ ] Docker deployment

---

## 💡 Future Ideas

* Smart home integration (Home Assistant)
* AI-based airflow optimization
* Energy efficiency tracking
* Alerts & notifications

---

## 🤝 Contributing

This is currently a personal project, but contributions and ideas are welcome.

---

## 👨‍💻 Author

Filip Gustavesen

---

## ⚡ License

MIT (or choose later)

---

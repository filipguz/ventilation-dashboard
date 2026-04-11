🌬️ Ventilation Dashboard

A full-stack IoT dashboard for monitoring a ventilation system (Östberg HERU) using Spring Boot, React, and Modbus TCP.

⸻

🚀 Overview

This project connects directly to a real ventilation system over Modbus TCP and exposes live operational data through a custom-built API and dashboard.

The goal was to understand how the system works internally and build a complete data pipeline from hardware → backend → frontend.

⸻

🧠 Architecture

[ Ventilation System (Östberg HERU) ]
              │
      (Modbus TCP / Ethernet)
              │
   [ Spring Boot Backend ]
              │
        REST API (JSON)
              │
 [ React Frontend Dashboard ]


⸻

🛠️ Tech Stack

Backend
	•	Java 17
	•	Spring Boot
	•	Maven
	•	Modbus TCP (digitalpetri)

Frontend
	•	React (Vite)
	•	JavaScript
	•	Custom dashboard UI

Infrastructure
	•	Linux (Ubuntu)
	•	Local network (LAN)
	•	Raspberry Pi (planned deployment)

⸻

🔌 Features
	•	✅ Reads real-time data from ventilation system via Modbus
	•	✅ Exposes data through REST API
	•	✅ Displays live data in a React dashboard
	•	🔜 Automation & remote access

⸻

📊 Example API Response

{
  "supplyFanPercent": 72,
  "extractFanPercent": 75,
  "recoveryPercent": 100,
  "rawRegisters": [15,24,72,75,45,100,0,0,0,0]
}


⸻

📦 Project Structure

ventilation-dashboard/
├── backend/         # Spring Boot API
├── frontend/        # React dashboard
├── docs/
└── README.md


⸻

⚙️ Backend Setup

cd backend
./mvnw spring-boot:run

API:

GET http://localhost:8080/api/ventilation/status


⸻

🎨 Frontend Setup

cd frontend
npm install
npm run dev

Open:

http://localhost:5173


⸻

🌐 Networking

The ventilation unit is connected directly via Ethernet and accessed over LAN.

To discover the device:

nmap 192.168.0.0/24

Modbus TCP runs on:

Port 502


⸻

🧠 Learning Goals

This project was used to:
	•	Learn React (previously only used Thymeleaf)
	•	Work with separated frontend/backend architecture
	•	Integrate real hardware using Modbus
	•	Build a full data pipeline from device → API → UI

⸻

⚠️ Safety
	•	Do not modify internal wiring
	•	Disconnect power before opening unit
	•	RJ45 connection is safe

⸻

🧪 Current Status
	•	✅ Real Modbus data integrated
	•	✅ Backend connected to hardware
	•	✅ Frontend displaying live data
	•	🔜 Better register mapping
	•	🔜 Mobile-friendly UI
	•	🔜 Remote access

⸻

📈 Roadmap
	•	Complete register mapping
	•	Historical data logging
	•	WebSocket live updates
	•	Mobile UI
	•	Raspberry Pi deployment
	•	Remote access (VPN / tunneling)

⸻

💡 Future Ideas
	•	Smart home integration (Home Assistant)
	•	Automation rules (CO₂ → fan boost)
	•	Energy monitoring

⸻

👨‍💻 Author

Filip Gustavesen

⸻

⚡ License

MIT (TBD)
:::

⸻

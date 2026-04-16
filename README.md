
🌬️ Ventilation Dashboard
A full-stack dashboard for reading live data from an Östberg HERU ventilation system using Spring Boot, React, and Modbus TCP.
Overview
This project connects directly to a real ventilation unit over Modbus TCP and exposes live operational data through a custom backend and frontend dashboard.
The current goal is read-only monitoring. The system reads live values from the ventilation unit and displays them in a custom React dashboard.
Control and write functionality may be added later, once register mapping is better understood and tested safely.
 
⸻
 
Current Scope
This project currently focuses on:
* Reading live data from the ventilation system
* Exposing the data through a Spring Boot API
* Displaying the data in a React dashboard
* Learning modern separated backend/frontend architecture
This project is intentionally read-only for now.
 
⸻
 
Why this project
I started this project to better understand how my home ventilation system works internally and to learn more about:
* React
* separated frontend/backend architecture
* hardware/software integration
* Modbus TCP
* real-world debugging and reverse engineering
Previously I had mostly worked with server-rendered applications using Thymeleaf. This project is also a way for me to get hands-on experience with a more modern frontend stack.
 
⸻
 
Architecture
[ Östberg HERU Ventilation Unit ]
                │
        (Modbus TCP / Ethernet)
                │
      [ Spring Boot Backend ]
                │
           REST API (JSON)
                │
      [ React Frontend Dashboard ]
 
⸻
 
Tech Stack
Backend
* Java 17
* Spring Boot
* Maven
* REST API
Frontend
* React
* Vite
* JavaScript
* Custom dashboard UI
Communication
* Modbus TCP
* Local network (LAN)
 
⸻
 
Features
Implemented
* Read live data from the ventilation system via Modbus TCP
* Expose data through a backend API
* Display live values in a React dashboard
* Local development setup for backend + frontend
Planned
* Better register mapping
* Cleaner domain model for temperatures, fan values and modes
* Historical data / charts
* Mobile-friendly dashboard
* Safe control/write support later
 
⸻
 
Example Data
Example raw register output from the ventilation unit:
[15, 24, 72, 75, 45, 100, 0, 0, 0, 0]
Example API response:
{
  "supplyFanPercent": 72,
  "extractFanPercent": 75,
  "recoveryPercent": 100,
  "rawReg0": 15,
  "rawReg1": 24,
  "mode": "UNKNOWN",
  "rawRegisters": [15, 24, 72, 75, 45, 100, 0, 0, 0, 0]
}
 
⸻
 
Project Structure
ventilation-dashboard/
├── backend/         # Spring Boot API
├── frontend/        # React dashboard
├── docs/            # Notes / mapping / screenshots
└── README.md
 
⸻
 
Backend Setup
cd backend
./mvnw spring-boot:run
API endpoint:
GET http://localhost:8080/api/ventilation/status
 
⸻
 
Frontend Setup
cd frontend
npm install
npm run dev
Open in browser:
http://localhost:5173
 
⸻
 
Development Workflow
You normally need two terminals:
Terminal 1 - Backend
cd backend
./mvnw spring-boot:run
Terminal 2 - Frontend
cd frontend
npm run dev
 
⸻
 
Modbus / Device Setup
The ventilation unit is connected to the local network over Ethernet.
To discover the device:
nmap 192.168.0.0/24
To verify Modbus TCP:
nmap 192.168.0.160 -p 502
Read test data using Python:
python test_modbus.py
 
⸻
 
Safety
This project is currently read-only.
That is intentional.
Before enabling any write functionality, register mapping must be verified carefully to avoid sending incorrect values to the ventilation system.
General safety notes:
* disconnect power before opening the unit
* do not modify internal wiring
* do not write to unknown Modbus registers
* treat all write functionality as future work
 
⸻
 
Current Status
* ✅ Ventilation unit connected to network
* ✅ Modbus TCP enabled
* ✅ Live data read successfully
* ✅ Spring Boot backend working
* ✅ React frontend working
* ✅ API and dashboard connected
* 🔜 Better register mapping
* 🔜 Live production-ready dashboard
* 🔜 Safe control support later
 
⸻
 
Roadmap
* Confirm register meanings more accurately
* Replace preliminary field names with real domain names
* Improve dashboard UI
* Add charts / historical data
* Improve error handling
* Add mobile-friendly layout
* Add safe write functionality later
 
⸻
 
Author
Filip Gustavesen
 
⸻
 
Notes
This is a practical learning project built around a real device.
The goal is not only to build a useful dashboard, but also to learn:
* system architecture
* frontend/backend separation
* industrial protocols
* debugging and reverse engineering
* working with real hardware
 


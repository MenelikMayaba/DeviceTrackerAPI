# Device Tracker API

A small Javalin-based API for tracking devices.  
Supports full CRUD operations (Create, Read, Update, Delete) using JSON over HTTP.

---

## 📦 Requirements

- Java 24 installed
- Maven installed
- Git (optional, if cloning from GitHub)



## run the server

cd "D:\Mayaba School\side\DeviceTrackerAPI"
mvn exec:java -Dexec.mainClass="deviceAPI.Main"

| Method | Endpoint        | Description        |
| ------ | --------------- | ------------------ |
| GET    | `/`             | Health check       |
| GET    | `/devices`      | List all devices   |
| GET    | `/devices/{id}` | Get a device by ID |
| POST   | `/devices`      | Add a new device   |
| PUT    | `/devices/{id}` | Update a device    |
| DELETE | `/devices/{id}` | Delete a device    |


## check health
# PowerShell
curl http://localhost:7000/

# Bash
curl http://localhost:7000/

## Add device(POST)
# PowerShell
curl -X POST http://localhost:7000/devices -H "Content-Type: application/json" -d '{"id":"1","name":"Laptop"}'

# Bash
curl -X POST http://localhost:7000/devices \
-H "Content-Type: application/json" \
-d '{"id":"1","name":"Laptop"}'


## List all devices
# PowerShell
curl http://localhost:7000/devices

# Bash
curl http://localhost:7000/devices

## get a device by ID
# PowerShell
curl http://localhost:7000/devices/1

# Bash
curl http://localhost:7000/devices/1

## update a device
# PowerShell
curl -X PUT http://localhost:7000/devices/1 -H "Content-Type: application/json" -d '{"id":"1","name":"Router"}'

# Bash
curl -X PUT http://localhost:7000/devices/1 \
-H "Content-Type: application/json" \
-d '{"id":"1","name":"Router"}'

## delete a device
# PowerShell
curl -X DELETE http://localhost:7000/devices/1

# Bash
curl -X DELETE http://localhost:7000/devices/1


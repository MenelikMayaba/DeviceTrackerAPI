# Device Tracker API

## Project Description
Device Tracker API is a small system integration project built with **Javalin** that allows users to **track and manage IoT-like devices**. The API supports basic CRUD operations: adding, updating, deleting, and retrieving device information. Device data is stored in an **in-memory HashMap** for simplicity, making it lightweight and easy to test.

This project demonstrates integration of multiple components in a simple system:
- **Backend:** Javalin REST API handling HTTP requests
- **Data Storage:** In-memory HashMap for device data management
- **Optional Frontend:** Basic HTML page fetching API data

**Key Features:**
- Add new devices with unique IDs
- Update device details
- Delete devices
- Retrieve all devices or a specific device
- Optional frontend dashboard displaying device data

**Tech Stack:**
- Java 17
- Javalin 5.x
- Jackson for JSON parsing
- Maven for project management

---

## Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/yourusername/DeviceTrackerAPI.git
cd DeviceTrackerAPI

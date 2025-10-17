package deviceAPI;

import io.javalin.*;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .start(7000);

        // Routes
        app.get("/devices", DeviceController.getAllDevices);
        app.get("/devices/{id}", DeviceController.getDevice);
        app.post("/devices", DeviceController.addDevice);
        app.put("/devices/{id}", DeviceController.updateDevice);
        app.delete("/devices/{id}", DeviceController.deleteDevice);

        // Optional: basic homepage
        app.get("/", ctx -> ctx.result("Device Tracker API is running!"));
    }
}
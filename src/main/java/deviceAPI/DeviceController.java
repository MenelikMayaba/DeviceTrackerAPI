package deviceAPI;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import java.util.*;

public class DeviceController {

    static Map<String, Device> devices = new HashMap<>();

    // List all devices
    public static Handler getAllDevices = ctx -> {
        ctx.json(devices.values());
    };

    // Get single device
    public static Handler getDevice = ctx -> {
        String id = ctx.pathParam("id");
        Device device = devices.get(id);
        if (device != null) ctx.json(device);
        else ctx.status(404).result("Device not found");
    };

    // Add device
    public static Handler addDevice = ctx -> {
        Device device = ctx.bodyAsClass(Device.class);
        devices.put(device.getId(), device);
        ctx.status(201).json(device);
    };

    // Update device
    public static Handler updateDevice = ctx -> {
        String id = ctx.pathParam("id");
        Device existing = devices.get(id);
        if (existing != null) {
            Device updated = ctx.bodyAsClass(Device.class);
            devices.put(id, updated);
            ctx.json(updated);
        } else ctx.status(404).result("Device not found");
    };

    // Delete device
    public static Handler deleteDevice = ctx -> {
        String id = ctx.pathParam("id");
        Device removed = devices.remove(id);
        if (removed != null) ctx.result("Device deleted");
        else ctx.status(404).result("Device not found");
    };
}

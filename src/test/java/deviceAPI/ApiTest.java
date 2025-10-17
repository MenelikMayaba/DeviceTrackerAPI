package deviceAPI;

import io.javalin.Javalin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {

    private Javalin app;
    private final HttpClient client = HttpClient.newHttpClient();
    private final String baseUrl = "http://localhost:7001";

    @BeforeEach
    void setUp() {
        app = Javalin.create(config -> {
            config.http.defaultContentType = "application/json";
        });

        app.post("/devices", DeviceController.addDevice);
        app.get("/devices/{id}", DeviceController.getDevice);

        app.start(7001);
    }

    @AfterEach
    void tearDown() {
        app.stop();
        DeviceController.devices.clear();
    }

    @Test
    void testAddDevice() throws Exception {
        String json = "{\"id\":\"1\", \"name\":\"Laptop\", \"status\":\"active\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/devices"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(201, response.statusCode());
        assertTrue(response.body().contains("Laptop"));
    }

    @Test
    void testGetDeviceById() throws Exception {
        // Add device first
        DeviceController.devices.put("1", new Device("1", "Laptop", "active"));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/devices/1"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("Laptop"));

        // Test not found
        HttpRequest notFoundRequest = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/devices/999"))
                .GET()
                .build();

        HttpResponse<String> notFoundResponse = client.send(notFoundRequest, HttpResponse.BodyHandlers.ofString());

        assertEquals(404, notFoundResponse.statusCode());
        assertEquals("Device not found", notFoundResponse.body());
    }
}
package mavensample.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

class MockApiServerTest {

    private static HttpServer server;

    @BeforeAll
    static void setUp() {
        server = MockApiServer.startServer();
    }

    @AfterAll
    static void tearDown() {
        if (server != null) {
            server.shutdownNow();
        }
    }

    @Test
    void testHelloEndpoint() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(MockApiServer.BASE_URI + "hello")
                .request()
                .get();

        assertEquals(200, response.getStatus());
        String body = response.readEntity(String.class);
        assertTrue(body.contains("<message>Hello, world!</message>"));
        assertTrue(body.contains("<from>Jersey+JacksonXML</from>"));

        response.close();
        client.close();
    }
}

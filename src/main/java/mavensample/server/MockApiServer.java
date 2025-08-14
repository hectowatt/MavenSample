package mavensample.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.net.URI;
import java.io.IOException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

@Path("/")
public class MockApiServer{
    public static final String BASE_URL = "http://localhost:8080/";

    public static HttpServer startServer(){
        final ResourceConfig rc = new ResourceConfig().packages("mavensample.server");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URL),rc);
    }

    @GET
    @Produces("text/plain")
    public String mockServer(){
        return "Mock API Server is running!";
    };

    public static void main(String[] args) throws IOException{

        final HttpServer server = startServer();
        System.out.println("Mock API Server started at " + BASE_URL);
        System.in.read();
        server.shutdownNow();

    }
    
}
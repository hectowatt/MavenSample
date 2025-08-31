package mavensample.server;

import java.io.IOException;
import java.net.URI;
import mavensample.AppConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class MockApiServer {
    public static final String BASE_URI = "http://localhost:8080/api/";

    public static HttpServer startServer(){
        final ResourceConfig rc = new AppConfig();
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),rc);
    }

    public static void main(String[] args) throws IOException {
        try {
            final HttpServer server = startServer();
            System.out.println("Server started at " + BASE_URI);
            System.in.read();
            server.shutdownNow();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("エラーが発生しました");
        }
    }
}
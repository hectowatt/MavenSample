package mavensample.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.JerseyClientBuilder;

public class ApiClient{
    public static void main(String[] args){
        Client client = JerseyClientBuilder.createClient();
        WebTarget target = client.target("http://localhost:8080/");

        String response = target.request().get(String.class);
        System.out.println("Response from Mock API Server: " + response);
    }
}
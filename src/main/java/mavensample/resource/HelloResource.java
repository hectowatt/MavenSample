package mavensample.resource;

import mavensample.model.Greeting;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Greeting getGreeting() throws Exception{
        try {
            System.out.println("アクセスされました");
            return new Greeting("Hello, world!", "Jersey+JacksonXML");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("エラーが発生しました");
        }
        return null;
    }
}
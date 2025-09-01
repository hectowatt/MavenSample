package mavensample.client;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import mavensample.model.Greeting;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class ApiClient{
    public static void main(String[] args){
        try {
            Client client = ClientBuilder.newClient();
            Response response = client.target("http://localhost:8080/api/hello").request().get();

            String xml = response.readEntity(String.class);
            System.out.println("XML:" + xml);

            // Jacksonでパースする
            XmlMapper xmlmapper = new XmlMapper();
            Greeting greeting = xmlmapper.readValue(xml, Greeting.class);
            System.out.println("パース後のオブジェクト:" + greeting);
            System.out.println("Message:" + greeting.getMessage());
            System.out.println("From:" + greeting.getFrom());

            response.close();
            client.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("エラー発生");
        }
    }
}
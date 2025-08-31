package mavensample;

import com.fasterxml.jackson.jaxrs.xml.JacksonJaxbXMLProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
    public AppConfig(){
        packages("mavensample.resource");
        register(JacksonJaxbXMLProvider.class);
    }
}

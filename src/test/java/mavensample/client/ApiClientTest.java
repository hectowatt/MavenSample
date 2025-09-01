package mavensample.client;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import mavensample.model.Greeting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApiClientTest {
    @Test
    public void testParseXml() throws Exception {
        String xml = "<greeting><message>Hello, world!</message><from>Jersey+JacksonXML</from></greeting>";

        XmlMapper xmlMapper = new XmlMapper();
        Greeting greeting = xmlMapper.readValue(xml, Greeting.class);

        assertEquals("Hello, world!", greeting.getMessage());
        assertEquals("Jersey+JacksonXML", greeting.getFrom());
    }
}

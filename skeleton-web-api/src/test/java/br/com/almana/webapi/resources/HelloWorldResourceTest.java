package br.com.almana.webapi.resources;

import br.com.almana.webapi.config.RestConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class HelloWorldResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new RestConfig();
    }

    @Test
    public void testSayHello() {
        final String chico = "chico";
        final Response response = target("/hello").queryParam("name", chico).request().get();
        assertEquals(200, response.getStatus());
        assertEquals(String.format("[{\"name\":\"%s\",\"age\":35},{\"name\":\"father of %s\",\"age\":65},{\"name\":\"mother of %s\",\"age\":65}]", chico, chico, chico), response.readEntity(String.class));
    }

    @Test
    public void testSayPersonalHello() {
        final Response response = target("/hello/1").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("{\"name\":\"chico\",\"age\":35}", response.readEntity(String.class));
    }
}
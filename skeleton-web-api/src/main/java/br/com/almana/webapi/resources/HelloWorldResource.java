package br.com.almana.webapi.resources;

import br.com.almana.domain.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello(@QueryParam("name") String name) {
        return Response.ok(new Person(name, 35)).build();
    }
}

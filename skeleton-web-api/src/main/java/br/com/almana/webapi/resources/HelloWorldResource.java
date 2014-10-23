package br.com.almana.webapi.resources;

import br.com.almana.domain.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("hello")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello(@QueryParam("name") String name) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(name, 35));
        people.add(new Person("father of " + name, 35 + 30));
        people.add(new Person("mother of " + name, 35 + 30));
        people.stream().forEach((p) -> p.getName());//just making sure lambdas are working
        return Response.ok(people).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayPersonalHello(@PathParam("id") Long id) {
        if (id == 1) {
            return Response.ok(new Person("chico", 35)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

package br.com.almana.webapi.resources;

import br.com.almana.domain.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
        people.add(new Person("mother of name" + name, 35 + 30));
        people.stream().forEach((p) -> System.out.println(p.getName()));
        return Response.ok(people).build();
    }
}

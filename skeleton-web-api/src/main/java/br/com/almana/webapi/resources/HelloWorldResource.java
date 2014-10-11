package br.com.almana.webapi.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloWorldResource  {

    @GET
    public Response sayHello() {
        return Response.ok("Hello World!").build();
    }
}

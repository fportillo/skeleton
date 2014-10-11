package br.com.almana.webapi.config;

import br.com.almana.webapi.resources.HelloWorldResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ResourceConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>( );
        resources.add(HelloWorldResource.class);
        return resources;
    }
}

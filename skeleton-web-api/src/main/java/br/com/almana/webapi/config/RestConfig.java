package br.com.almana.webapi.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class RestConfig extends ResourceConfig {
    public RestConfig() {
        packages("br.com.almana.webapi.resources");
    }
}

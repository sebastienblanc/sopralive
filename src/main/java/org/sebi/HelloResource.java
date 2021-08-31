package org.sebi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class HelloResource {

    @RestClient
    RemoteService service;

    @ConfigProperty(name = "greeting")
    String greeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "fallback")
    public String hello() {
        return service.remoteHello();
    }

    private String fallback(){
        return "I am the fallback";
    }

    @GET
    @Path("/fr")
    @Produces(MediaType.TEXT_PLAIN)
    public String bonjour() {
        return "Bonjour la Suisse!";
    }
}

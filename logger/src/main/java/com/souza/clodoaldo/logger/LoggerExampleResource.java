package com.souza.clodoaldo.logger;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class LoggerExampleResource {
    @Inject
    Logger log;

    @Path("/log")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String showMessageAndWriteAMessageInLog() {
        log.info("Logger: Hello from RESTEasy Reactive");
        return "Hello from RESTEasy Reactive";
    }
}
package org.acme.rest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("tcs")
public class TCsResource {


    @ConfigProperty(name = "tcs.file") 
    String file;

    @Inject
    Template tcs;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        
        String message = "Terms and conditions will go here";

        java.nio.file.Path path = Paths.get(file);

        try {
            message = Files.readAllLines(path).get(0);
        } catch (IOException e1) {
            System.out.println("WARN: no such file. Setting default T&Cs message");
        }

        return tcs.data("active", "tcs")
                .data("message", message);
    }

}
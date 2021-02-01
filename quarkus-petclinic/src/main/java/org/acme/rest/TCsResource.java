package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("tcs")
public class TCsResource {

    @Inject
    Template tcs;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return tcs.data("active", "tcs")
                .data("message", "Terms and conditions will go here");
    }

}
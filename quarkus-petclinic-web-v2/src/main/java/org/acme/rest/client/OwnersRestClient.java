package org.acme.rest.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.dto.PetDetails;
import org.acme.dto.PetRequest;
import org.acme.model.Owner;
import org.acme.model.PetType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient
public interface OwnersRestClient {
          
    @GET
    @Path("owners")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Owner> findAll();

    @GET
    @Path("owners/filter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Owner> findOwnerByLastName(@QueryParam("lastName") String lastName);

    @GET
    @Path("owners/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Owner findOwnerById(@PathParam("ownerId") long ownerId);

    @PUT 
    @Path("owners/{ownerId}")
    public Response updateOwner(@PathParam("ownerId") long ownerId, Owner ownerRequest);

    @POST
    @Path("owners")
    public Response createOwner(Owner theOwner);

    @GET
    @Path("owners/*/pets/{petId}")
    public PetDetails findPetById(@PathParam("petId") long petId);
    
    @GET
    @Path("petTypes/filter")
    public PetType findPetTypeByName(@QueryParam("petTypeName") String petTypeName);

    @PUT
    @Path("owners/{ownerId}/pets/{petId}")
    public Response updatePet(@PathParam("ownerId") long ownerId, @PathParam("petId") long petId, PetRequest petRequest);

    @POST
    @Path("owners/{ownerId}/pets")
    public Response addPetToOwner(@PathParam("ownerId") long ownerId, PetRequest petRequest);

}

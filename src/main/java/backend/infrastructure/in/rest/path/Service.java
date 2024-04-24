package backend.infrastructure.in.rest.path;

import backend.infrastructure.out.repository.db.contact.ContactRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ping")
public class Service {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    private ContactRepository repository;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ping(String requestBody) {
        return Response.ok(repository.getAllContacts()).build();
        // return Response.status(Response.Status.OK).entity("{\"message\": \"Reset request created successfully\"}").build();
    }
   
}

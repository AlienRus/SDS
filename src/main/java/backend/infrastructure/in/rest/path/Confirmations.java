package backend.infrastructure.in.rest.path;

import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/confirmations")
public class Confirmations {

    @Context
    private ContainerRequestContext requestContext;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response addConfirmationRecord(String requestBody) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Confirmation record added successfully\"}").build();
    }
}

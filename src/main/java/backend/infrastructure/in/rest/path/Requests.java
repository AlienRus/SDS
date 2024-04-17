package backend.infrastructure.in.rest.path;

import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/requests")
public class Requests {

    @Context
    private ContainerRequestContext requestContext;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{requestId}")
    public Response updateRequest(@PathParam("requestId") int requestId, String requestDataJSON) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Request updated successfully\"}").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{positionId}")
    public Response addRequest(@PathParam("positionId") int positionId, String requestDataJSON) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Request added successfully\"}").build();
    }

    @DELETE
    @TokenRequired
    @Path("/{positionId}")
    public Response deleteRequest(@PathParam("positionId") int positionId) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Request deleted successfully\"}").build();
    }
}

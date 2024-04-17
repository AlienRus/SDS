package backend.infrastructure.in.rest.path;

import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/positions")
public class Positions {

    @Context
    private ContainerRequestContext requestContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}")
    public Response getPositionInfo(@PathParam("lotId") int lotId) {
        return Response.status(Response.Status.OK).entity(
                "{\"positionId\": 123, \"lotId\": " + lotId + ", \"itemName\": \"Sample Item\", \"quantity\": 10}")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}")
    public Response updatePosition(@PathParam("lotId") int lotId, String positionRequestJSON) {
        // Mock response for PUT /positions/{lotId}
        return Response.status(Response.Status.OK).entity("{\"message\": \"Position updated successfully\"}").build();
    }

    @DELETE
    @TokenRequired
    @Path("/{positionId}")
    public Response deletePosition(@PathParam("positionId") int positionId) {
        // Mock response for DELETE /positions/{positionId}
        return Response.status(Response.Status.OK).entity("{\"message\": \"Position deleted successfully\"}").build();
    }
}

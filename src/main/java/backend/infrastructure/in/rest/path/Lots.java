package backend.infrastructure.in.rest.path;

import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/lots")
public class Lots {

    @Context
    private ContainerRequestContext requestContext;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response addLot(String lotDataJSON) {
        return Response.status(Response.Status.OK).entity("{'message': 'Lot added successfully'}").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}")
    public Response getLot(@PathParam("lotId") int lotId) {
        return Response.status(Response.Status.OK).entity("{\"lotId\": " + lotId + ", \"itemName\": \"Sample Item\"}")
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}")
    public Response updateLot(String lotDataJSON, @PathParam("lotId") int lotId) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Lot updated successfully\"}").build();
    }

    @DELETE
    @TokenRequired
    @Path("/{lotId}")
    public Response deleteLot(@PathParam("lotId") int lotId) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Lot deleted successfully\"}").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}/positions")
    public Response addPositionToLot(String positionRequestJSON, @PathParam("lotId") int lotId) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Position added to lot successfully\"}")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{userId}/{status}")
    public Response getLotsByUserAndStatus(@PathParam("userId") int userId, @PathParam("status") String status) {
        return Response.status(Response.Status.OK)
                .entity("{\"userId\": " + userId + ", \"status\": \"" + status + "\", \"lots\": []}").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{groupId}")
    public Response getLotsByGroup(@PathParam("groupId") int groupId) {
        return Response.status(Response.Status.OK).entity("" + groupId).build();
    }
}

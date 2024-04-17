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

@Path("/groups")
public class Groups {

    @Context
    private ContainerRequestContext requestContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response getGroups() {
        return Response.status(Response.Status.OK).entity("[{\"groupId\": 1, \"name\": \"Group 1\"}, {\"groupId\": 2, \"name\": \"Group 2\"}]").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response addGroup(String requestBody) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Group added successfully\"}").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response updateGroup(String requestBody) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Group updated successfully\"}").build();
    }

    @DELETE
    @TokenRequired
    @Path("/{groupId}")
    public Response deleteGroup(@PathParam("groupId") int groupId) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Group deleted successfully with ID: " + groupId + "\"}").build();
    }
}

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

@Path("/users")
public class Users {

    @Context
    private ContainerRequestContext requestContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response getAllUsers() {
        return Response.status(Response.Status.OK).entity("[{\"userId\": 1, \"name\": \"User 1\", \"role\": \"Supplier\"}, {\"userId\": 2, \"name\": \"User 2\", \"role\": \"Supply Specialist\"}]").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") int userId, String userDataJSON) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"User updated successfully\"}").build();
    }

    @DELETE
    @TokenRequired
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") int userId) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"User deleted successfully\"}").build();
    }
}

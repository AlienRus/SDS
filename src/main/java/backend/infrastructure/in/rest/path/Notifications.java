package backend.infrastructure.in.rest.path;

import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/notifications")
public class Notifications {

    @Context
    private ContainerRequestContext requestContext;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{supplierId}")
    public Response setNotifications(@PathParam("supplierId") int supplierId, String requestBody) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"Notifications set successfully for supplierId: " + supplierId + "\"}").build();
    }
}

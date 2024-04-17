package backend.infrastructure.in.rest.path;

import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/lists")
public class Lists {

    @Context
    private ContainerRequestContext requestContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}")
    public Response getConcurrentList(@PathParam("lotId") int lotId) {
        return Response.status(Response.Status.OK).entity("{\"lotId\": " + lotId
                + ", \"items\": [{\"itemId\": 1, \"itemName\": \"Item 1\"}, {\"itemId\": 2, \"itemName\": \"Item 2\"}]}")
                .build();
    }
}

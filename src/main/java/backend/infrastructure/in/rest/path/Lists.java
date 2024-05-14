package backend.infrastructure.in.rest.path;

import backend.application.interfaces.in.IListService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.response.ListResponse;
import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
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

    @Inject
    @Built
    private IListService listService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}")
    public Response getConcurrentList(@PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            
            return Response.ok(new ListResponse(listService.getListByLotId(lotId))).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

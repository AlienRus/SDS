package backend.infrastructure.in.rest.path;

import backend.application.dto.RequestDto;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.repository.db.request.RequestRepository;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
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

    @Inject
    private RequestRepository requestRepository;

    private Jsonb jsonb = JsonbBuilder.create();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{requestId}")
    public Response updateRequest(@PathParam("requestId") Long requestId, String requestDataJSON) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            RequestDto requestDto = jsonb.fromJson(requestDataJSON, RequestDto.class);
            requestRepository.updateRequest(requestDto);
            return Response.status(201).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
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

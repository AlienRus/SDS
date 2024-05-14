package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.LotPositionDto;
import backend.application.interfaces.in.ILotPositionService;
import backend.application.interfaces.in.IPositionService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.response.PositionByLotIdResponse;
import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
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

    @Inject
    @Built
    private ILotPositionService lotPositionService;

    @Inject
    @Built
    private IPositionService positionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}") // +
    public Response getPositionInfo(@PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {

            List<LotPositionDto> lotPositionDtos = lotPositionService.getLotPositionsByLotId(lotId);

            List<PositionByLotIdResponse> responses = new ArrayList<PositionByLotIdResponse>();

            for (LotPositionDto lotPositionDto : lotPositionDtos) {
                responses.add(new PositionByLotIdResponse(lotPositionDto));
            }

            return Response.ok(responses).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
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
    @Path("/{positionId}") // +
    public Response deletePosition(@PathParam("positionId") Long positionId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            LotPositionDto lotPositionDto = lotPositionService.getLotPositionById(positionId);
            lotPositionService.deleteLotPosition(lotPositionDto);

            return Response.ok().build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

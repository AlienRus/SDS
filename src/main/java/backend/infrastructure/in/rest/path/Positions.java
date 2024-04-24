package backend.infrastructure.in.rest.path;

import backend.application.dto.LotPositionDto;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.repository.db.lotPosition.LotPositionRepository;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
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
    private LotPositionRepository lotPositionRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}")
    public Response getPositionInfo(@PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            LotPositionDto lotPositionDto = lotPositionRepository.getLotPositionById(lotId);
            JsonObjectBuilder builder = Json.createObjectBuilder()
                    .add("id", lotPositionDto.getId())
                    .add("itemName", lotPositionDto.getPosition().getItemName())
                    .add("priceForOne", lotPositionDto.getPosition().getPriceForOne())
                    .add("count", lotPositionDto.getPosition().getCount())
                    .add("unitName", lotPositionDto.getPosition().getUnitName())
                    .add("winner", lotPositionDto.getPosition().getWinner().getId());

            // Создаем JsonObject из построителя

            // Возвращаем успешный ответ с JSON
            return Response.ok(builder.build()).build();
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
    @Path("/{positionId}")
    public Response deletePosition(@PathParam("positionId") int positionId) {
        // Mock response for DELETE /positions/{positionId}
        return Response.status(Response.Status.OK).entity("{\"message\": \"Position deleted successfully\"}").build();
    }
}

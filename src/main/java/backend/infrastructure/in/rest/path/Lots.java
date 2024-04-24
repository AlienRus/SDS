package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.LotDto;
import backend.application.dto.PositionDto;
import backend.application.dto.PositionRequestDto;
import backend.application.dto.SupplySpecialistLotDto;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.repository.db.lot.LotRepository;
import backend.infrastructure.out.repository.db.lotFile.LotFileRepository;
import backend.infrastructure.out.repository.db.lotPosition.LotPositionRepository;
import backend.infrastructure.out.repository.db.supplySpecialistLot.SupplySpecialistLotRepository;
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

    @Inject
    private LotRepository lotRepository;

    @Inject
    private LotFileRepository lotFileRepository;

    @Inject
    private SupplySpecialistLotRepository supplySpecialistLotRepository;

    @Context
    private ContainerRequestContext requestContext;

    private Jsonb jsonb = JsonbBuilder.create();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response addLot(String lotDataJSON) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        try {
            LotDto lot = jsonb.fromJson(lotDataJSON, LotDto.class);
            lotRepository.createLot(lot);
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}")
    public Response getLot(@PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            LotDto lotDto = lotRepository.getLotById(lotId);
            JsonObjectBuilder builder = Json.createObjectBuilder()
                    .add("name", lotDto.getName())
                    .add("openDate", lotDto.getOpenDate().toString())
                    .add("closeDate", lotDto.getCloseDate().toString())
                    .add("status", lotDto.getStatus().getStatusName())
                    .add("canOwnWay", lotDto.getCanOwnWay())
                    .add("lotCreator", lotDto.getLotCreator().getEmail())
                    .add("groupEts", lotDto.getGroupEts().getGroupName());

            builder.add("rules", jsonb.toJson(lotDto.getRules()));
            builder.add("lotFiles", jsonb.toJson(lotFileRepository.getAllLotFilesByLotId(lotId)));

            // Создаем JsonObject из построителя
            JsonObject responseJson = builder.build();

            // Возвращаем успешный ответ с JSON
            return Response.ok(responseJson).build();
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
    public Response updateLot(String lotDataJSON, @PathParam("lotId") int lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            LotDto lot = jsonb.fromJson(lotDataJSON, LotDto.class);
            lotRepository.updateLot(lot);
            return Response.ok(lot).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @DELETE
    @TokenRequired
    @Path("/{lotId}")
    public Response deleteLot(@PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            LotDto lot = lotRepository.getLotById(lotId);
            lotRepository.deleteLot(lot);
            return Response.ok(lot).build();
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
    @Path("/{lotId}/positions")
    public Response addPositionToLot(String positionRequestJSON, @PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        try {

        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{userId}/statuses/{status}")
    public Response getLotsByUserAndStatus(@PathParam("userId") Long userId, @PathParam("status") String status) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            List<SupplySpecialistLotDto> data = supplySpecialistLotRepository
                    .getSupplySpecialistLotsByIdAndStatus(userId, status);
            return Response.ok(data).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/groups/{groupId}")
    public Response getLotsByGroup(@PathParam("groupId") Long groupId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            List<LotDto> lotDtos = lotRepository.getAllLotsByGroup(groupId);
            List<JsonObject> dataJson = new ArrayList<JsonObject>();
            for (LotDto lotDto : lotDtos) {
                JsonObjectBuilder builder = Json.createObjectBuilder()
                        .add("id", lotDto.getId())
                        .add("name", lotDto.getName())
                        .add("openDate", lotDto.getOpenDate().toString())
                        .add("closeDate", lotDto.getCloseDate().toString());
                dataJson.add(builder.build());
            }

            return Response.ok(dataJson).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.LotPositionDto;
import backend.application.dto.PositionDto;
import backend.application.dto.SupplierDto;
import backend.application.interfaces.in.ILotPositionService;
import backend.application.interfaces.in.IPositionService;
import backend.application.interfaces.in.ISupplierService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.in.rest.request.put.position.UpdatePositionRequest;
import backend.infrastructure.out.response.PositionByLotIdResponse;
import jakarta.inject.Inject;
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
    @Built
    private ILotPositionService lotPositionService;

    @Inject
    @Built
    private IPositionService positionService;

    @Inject
    @Built
    private ISupplierService supplierService;

    private Jsonb jsonb = JsonbBuilder.create();

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
    @Path("/{positionId}")
    public Response updatePosition(@PathParam("positionId") Long positionId, String positionRequestJSON) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {

            PositionDto positionDto = positionService.getPositionById(positionId);

            UpdatePositionRequest updatePositionRequest = jsonb.fromJson(positionRequestJSON,
                    UpdatePositionRequest.class);

            if (updatePositionRequest.getCount() != null) {
                positionDto.setCount(updatePositionRequest.getCount());
            }

            if (updatePositionRequest.getItemName() != null) {
                positionDto.setItemName(updatePositionRequest.getItemName());
            }

            if (updatePositionRequest.getPriceForOne() != null) {
                positionDto.setPriceForOne(updatePositionRequest.getPriceForOne());
            }

            if (updatePositionRequest.getUnitName() != null) {
                positionDto.setUnitName(updatePositionRequest.getUnitName());
            }

            if (updatePositionRequest.getSupplierWinnerId() != null) {
                Long supplierId = updatePositionRequest.getSupplierWinnerId();
                if (supplierId != null) {
                    SupplierDto supplierDto = supplierService
                            .getSupplierById(updatePositionRequest.getSupplierWinnerId());

                    positionDto.setWinner(supplierDto);
                } else {
                    return Response.status(404).entity("No such supplier").build();
                }
            }

            positionService.updatePosition(positionDto);

            return Response.ok().build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
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
            PositionDto positionDto = positionService.getPositionById(positionId);
            positionService.deletePosition(positionDto);

            return Response.ok().build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

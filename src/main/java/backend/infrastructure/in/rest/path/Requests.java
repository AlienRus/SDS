package backend.infrastructure.in.rest.path;

import backend.application.dto.PositionDto;
import backend.application.dto.PositionRequestDto;
import backend.application.dto.RequestDto;
import backend.application.dto.SupplierDto;
import backend.application.interfaces.in.IPositionRequestService;
import backend.application.interfaces.in.IPositionService;
import backend.application.interfaces.in.IRequestService;
import backend.application.interfaces.in.ISupplierService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.in.rest.request.NewRequestRequestDto;
import jakarta.inject.Inject;
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

@Path("/requests")
public class Requests {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private IRequestService requestService;

    @Inject
    @Built
    private IPositionService positionService;

    @Inject
    @Built
    private IPositionRequestService positionRequestService;

    @Inject
    @Built
    private ISupplierService supplierService;

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
            requestService.updateRequest(requestDto);
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
    @Path("/{positionId}") // +
    // Добавление заявки по номеру позиции
    public Response addRequest(@PathParam("positionId") Long positionId, String requestDataJSON) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            NewRequestRequestDto newRequestRequestDto = jsonb.fromJson(requestDataJSON, NewRequestRequestDto.class);
            SupplierDto supplierDto = supplierService
                    .getSupplierById(Long.valueOf(newRequestRequestDto.getRequestFiles().getSupplierId()));

            RequestDto requestDto = new RequestDto(newRequestRequestDto.getPriceForOne(),
                    newRequestRequestDto.getCount(), newRequestRequestDto.getItemName(),
                    newRequestRequestDto.getDeliveryTime(), supplierDto);

            PositionDto positionDto = positionService.getPositionById(positionId);
            PositionRequestDto positionRequestDto = new PositionRequestDto(positionDto, requestDto);

            positionRequestService.createPositionRequest(positionRequestDto);

            return Response.ok(positionRequestDto).build();

        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired // +
    public Response getAllRequests() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            return Response.ok(positionRequestService.getAllPositionRequests()).build();

        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @DELETE
    @TokenRequired
    @Path("/{requestId}") // -
    public Response deleteRequest(@PathParam("requestId") Long requestId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            PositionRequestDto positionRequestDto = positionRequestService.getPositionRequestById(requestId);
            positionRequestService.deletePositionRequest(positionRequestDto);

            return Response.ok().build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

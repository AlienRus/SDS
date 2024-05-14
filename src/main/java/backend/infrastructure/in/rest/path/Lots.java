package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.GroupEtDto;
import backend.application.dto.LotDto;
import backend.application.dto.LotFileDto;
import backend.application.dto.LotPositionDto;
import backend.application.dto.LotRuleDto;
import backend.application.dto.PaymentMethodDto;
import backend.application.dto.PositionDto;
import backend.application.dto.ShippingMethodDto;
import backend.application.dto.StatusDto;
import backend.application.dto.SupplySpecialistDto;
import backend.application.dto.SupplySpecialistLotDto;
import backend.application.interfaces.in.IGroupEtService;
import backend.application.interfaces.in.ILotFileService;
import backend.application.interfaces.in.ILotPositionService;
import backend.application.interfaces.in.ILotService;
import backend.application.interfaces.in.IPaymentMethodService;
import backend.application.interfaces.in.IPositionService;
import backend.application.interfaces.in.IShippingMethodService;
import backend.application.interfaces.in.IStatusService;
import backend.application.interfaces.in.ISupplySpecialistLotService;
import backend.application.interfaces.in.ISupplySpecialistService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.in.rest.request.LotRequestDto;
import backend.infrastructure.out.response.LotByGroupResponse;
import backend.infrastructure.out.response.LotByIdResponse;
import backend.infrastructure.out.response.LotByUserAndStatusResponse;
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

@Path("/lots")
public class Lots {

    @Inject
    @Built
    private ILotService lotService;

    @Inject
    @Built
    private ILotPositionService lotPositionService;

    @Inject
    @Built
    private ILotFileService lotFileService;

    @Inject
    @Built
    private IPositionService positionService;

    @Inject
    @Built
    private ISupplySpecialistService supplySpecialistService;

    @Inject
    @Built
    private ISupplySpecialistLotService supplySpecialistLotService;

    @Inject
    @Built
    private IStatusService statusService;

    @Inject
    @Built
    private IShippingMethodService shippingMethodService;

    @Inject
    @Built
    private IPaymentMethodService paymentMethodService;

    @Inject
    @Built
    private IGroupEtService groupEtService;

    @Context
    private ContainerRequestContext requestContext;

    private Jsonb jsonb = JsonbBuilder.create();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired // +
    public Response addLot(String lotDataJSON) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        try {

            LotRequestDto lotRequestDto = jsonb.fromJson(lotDataJSON, LotRequestDto.class);

            StatusDto statusDto = statusService.getStatusById(lotRequestDto.getStatusId());
            SupplySpecialistDto supplySpecialistDto = supplySpecialistService
                    .getSupplySpecialistById(lotRequestDto.getLotCreatorId());
            ShippingMethodDto shippingMethodDto = shippingMethodService
                    .getShippingMethodById(lotRequestDto.getRules().getShippingMethodId());
            PaymentMethodDto paymentMethodDto = paymentMethodService
                    .getPaymentMethodById(lotRequestDto.getRules().getPaymentMethodId());

            LotRuleDto lotRuleDto = new LotRuleDto(shippingMethodDto, paymentMethodDto,
                    lotRequestDto.getRules().getComment());

            GroupEtDto groupEtDto = groupEtService.getGroupEtById(lotRequestDto.getGroupEtsId());

            LotDto lotDto = new LotDto(lotRequestDto.getId(), lotRequestDto.getName(), lotRequestDto.getOpenDate(),
                    lotRequestDto.getCloseDate(), statusDto, lotRequestDto.isCanOwnWay(), supplySpecialistDto,
                    lotRuleDto, groupEtDto);

            lotService.createLot(lotDto);
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired // +
    public Response getLots() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            List<LotDto> lotDtos = lotService.getAllLots();

            List<LotByIdResponse> responses = new ArrayList<LotByIdResponse>();

            for (LotDto lotDto : lotDtos) {
                List<LotFileDto> lotFileDtos = lotFileService.getAllLotFilesByLotId(lotDto.getId());
                LotFileDto lotFileDto;
                if (lotFileDtos.isEmpty()) {
                    lotFileDto = null;
                } else {

                    lotFileDto = lotFileDtos.get(0);
                }
                responses.add(new LotByIdResponse(lotDto, lotFileDto));
            }

            return Response.ok(responses).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{lotId}") // +
    public Response getLot(@PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            LotDto lotDto = lotService.getLotById(lotId);
            List<LotFileDto> lotFileDtos = lotFileService.getAllLotFilesByLotId(lotDto.getId());
            LotFileDto lotFileDto;
            if (lotFileDtos.isEmpty()) {
                lotFileDto = null;
            } else {
                lotFileDto = lotFileDtos.get(0);
            }

            return Response.ok(new LotByIdResponse(lotDto, lotFileDto)).build();
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
            lotService.updateLot(lot);
            return Response.ok(lot).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @DELETE
    @TokenRequired
    @Path("/{lotId}") // +
    public Response deleteLot(@PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            LotDto lot = lotService.getLotById(lotId);
            lotService.deleteLot(lot);
            return Response.ok().build();
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
    @Path("/{lotId}/positions") // +
    // Добавление позиции в лот
    public Response addPositionToLot(String positionRequestJSON, @PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        try {
            LotDto lotDto = lotService.getLotById(lotId);
            PositionDto positionDto = jsonb.fromJson(positionRequestJSON, PositionDto.class);
            LotPositionDto lotPositionDto = new LotPositionDto(positionDto.getId(), lotDto, positionDto);
            lotPositionService.createLotPosition(lotPositionDto);

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
    @Path("/{userId}/statuses/{status}") // +
    // Получение информации о лотах юзера по указанному статусу
    public Response getLotsByUserAndStatus(@PathParam("userId") Long userId, @PathParam("status") String status) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            List<SupplySpecialistLotDto> specialistLotDtos = supplySpecialistLotService
                    .getSupplySpecialistLotsByIdAndStatus(userId, status);

            List<LotByUserAndStatusResponse> responses = new ArrayList<LotByUserAndStatusResponse>();

            for (SupplySpecialistLotDto specialistLotDto : specialistLotDtos) {
                responses.add(new LotByUserAndStatusResponse(specialistLotDto.getLot()));
            }

            return Response.ok(responses).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/groups/{groupId}") // +
    // Получение информации о лотах по группе
    public Response getLotsByGroup(@PathParam("groupId") Long groupId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            List<LotDto> lotDtos = lotService.getAllLotsByGroup(groupId);

            List<LotByGroupResponse> responses = new ArrayList<LotByGroupResponse>();

            for (LotDto lotDto : lotDtos) {
                responses.add(new LotByGroupResponse(lotDto));
            }

            return Response.ok(responses).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

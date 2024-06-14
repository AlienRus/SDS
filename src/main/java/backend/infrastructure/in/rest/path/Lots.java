package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.GroupEtDto;
import backend.application.dto.LotDto;
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
import backend.infrastructure.in.rest.request.AddPositionsToLotRequestDataDto;
import backend.infrastructure.in.rest.request.AddPositionsToLotRequestDto;
import backend.infrastructure.in.rest.request.LotRequestDto;
import backend.infrastructure.in.rest.request.put.lot.UpdateLotRequest;
import backend.infrastructure.out.response.LotByGroupResponse;
import backend.infrastructure.out.response.LotByUserAndStatusResponse;
import backend.infrastructure.out.response.LotWithPositionsResponse;
import backend.infrastructure.out.response.PositionByLotIdResponse;
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

import java.util.logging.Level;
import java.util.logging.Logger;

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
    //
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

            LotDto lotDto = new LotDto(lotRequestDto.getName(), lotRequestDto.getOpenDate(),
                    lotRequestDto.getCloseDate(), statusDto, lotRequestDto.isCanOwnWay(), supplySpecialistDto,
                    lotRuleDto, groupEtDto, lotRequestDto.getFilePath());

            lotService.createLot(lotDto);

            Long newLotId = lotService.getLatestLotId();

            LotDto newLotDto = lotService.getLotById(newLotId);

            for (PositionDto positionDto : lotRequestDto.getPositions()) {
                positionDto.setLot(newLotDto);
                LotPositionDto lotPositionDto = new LotPositionDto(newLotDto, positionDto);

                lotPositionService.createLotPosition(lotPositionDto);
            }

            return Response.ok().build();

        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
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

            List<LotWithPositionsResponse> responses = new ArrayList<LotWithPositionsResponse>();

            for (LotDto lotDto : lotDtos) {

                List<PositionByLotIdResponse> positionResponseDtos = new ArrayList<PositionByLotIdResponse>();
                List<LotPositionDto> lotPositionDtos = lotPositionService.getLotPositionsByLotId(lotDto.getId());

                for (LotPositionDto lotPositionDto : lotPositionDtos) {
                    positionResponseDtos.add(new PositionByLotIdResponse(lotPositionDto));
                }

                responses.add(new LotWithPositionsResponse(lotDto, positionResponseDtos));
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
            List<PositionByLotIdResponse> positionResponseDtos = new ArrayList<PositionByLotIdResponse>();
            List<LotPositionDto> lotPositionDtos = lotPositionService.getLotPositionsByLotId(lotId);

            for (LotPositionDto lotPositionDto : lotPositionDtos) {
                positionResponseDtos.add(new PositionByLotIdResponse(lotPositionDto));
            }

            return Response.ok(new LotWithPositionsResponse(lotDto, positionResponseDtos)).build();
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
    public Response updateLot(String lotDataJSON, @PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            LotDto lot = lotService.getLotById(lotId);
            if (lot == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Lot not found").build();
            }

            UpdateLotRequest updateLotRequest = jsonb.fromJson(lotDataJSON, UpdateLotRequest.class);

            if (updateLotRequest.getCanOwnWay() != null) {
                lot.setCanOwnWay(updateLotRequest.getCanOwnWay());
            }

            if (updateLotRequest.getCloseDate() != null) {
                lot.setCloseDate(updateLotRequest.getCloseDate());
            }

            if (updateLotRequest.getName() != null) {
                lot.setName(updateLotRequest.getName());
            }

            if (updateLotRequest.getOpenDate() != null) {
                lot.setOpenDate(updateLotRequest.getOpenDate());
            }

            LotRuleDto lotRuleDto = lot.getRules();
            if (updateLotRequest.getRules().getComment() != null) {
                lotRuleDto.setComment(updateLotRequest.getRules().getComment());
            }

            if (updateLotRequest.getRules().getPaymentMethodId() != null) {
                lotRuleDto.setPaymentMethod(
                        paymentMethodService.getPaymentMethodById(updateLotRequest.getRules().getPaymentMethodId()));
            }

            if (updateLotRequest.getRules().getShippingMethodId() != null) {
                lotRuleDto.setShippingMethod(
                        shippingMethodService.getShippingMethodById(updateLotRequest.getRules().getShippingMethodId()));
            }
            lot.setRules(lotRuleDto);

            if (updateLotRequest.getStatusId() != null) {
                lot.setStatus(statusService.getStatusById(updateLotRequest.getStatusId()));
            }

            if (updateLotRequest.getFilePath() != null) {
                lot.setFilePath(updateLotRequest.getFilePath());
            }

            lotService.updateLot(lot);
            return Response.ok().build();
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
            AddPositionsToLotRequestDto addPositionsToLotRequestDto = jsonb.fromJson(positionRequestJSON,
                    AddPositionsToLotRequestDto.class);

            for (AddPositionsToLotRequestDataDto positionData : addPositionsToLotRequestDto.getData()) {

                PositionDto positionDto = new PositionDto(positionData.getItemName(), positionData.getPriceForOne(),
                        positionData.getCount(), positionData.getUnitName(), lotDto);

                LotPositionDto lotPositionDto = new LotPositionDto(lotDto, positionDto);
                Logger.getLogger(Lots.class.getName()).log(Level.WARNING, lotPositionDto.toString());
                lotPositionService.createLotPosition(lotPositionDto);
            }

        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
        return Response.ok().build();
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

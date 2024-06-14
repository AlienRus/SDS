package backend.infrastructure.in.rest.path;

import backend.application.dto.SupplierDto;
import backend.application.dto.SupplySpecialistDto;
import backend.application.interfaces.in.ISupplierService;
import backend.application.interfaces.in.ISupplySpecialistService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/confirmations")
public class Confirmations {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private ISupplierService supplierService;

    @Inject
    @Built
    private ISupplySpecialistService supplySpecialistService;

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/roles/{roleName}/users/{userId}")
    public Response addConfirmationRecord(@PathParam("roleName") String roleName, @PathParam("userId") Long userId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            if (roleName.equals("supplier")) {
                SupplierDto supplierDto = supplierService.getSupplierById(userId);
                if (supplierDto == null) {
                    return Response.status(404).entity("No such user").build();
                }
                supplierDto.setIsApproved(true);
                supplierService.updateSupplier(supplierDto);

                return Response.ok().build();

            } else if (roleName.equals("supplySpecialist")) {
                SupplySpecialistDto supplySpecialistDto = supplySpecialistService.getSupplySpecialistById(userId);
                if (supplySpecialistDto == null) {
                    return Response.status(404).entity("No such user").build();
                }

                supplySpecialistDto.setIsApproved(true);
                supplySpecialistService.updateSupplySpecialist(supplySpecialistDto);

                return Response.ok().build();

            } else {
                return Response.status(400).entity("Wrong role name").build();
            }

        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

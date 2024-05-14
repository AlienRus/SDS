package backend.infrastructure.in.rest.path;

import backend.application.dto.SupplierDto;
import backend.application.interfaces.in.ISupplierService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.response.SupplierByIdResponse;
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

@Path("/suppliers")
public class Suppliers {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private ISupplierService supplierService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{supplierId}")
    public Response getSupplierData(@PathParam("supplierId") Long supplierId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {

            SupplierDto supplierDto = supplierService.getSupplierById(supplierId);

            return Response.ok(new SupplierByIdResponse(supplierDto)).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}

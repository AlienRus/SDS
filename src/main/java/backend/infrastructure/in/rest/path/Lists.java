package backend.infrastructure.in.rest.path;

import backend.application.dto.SupplierDto;
import backend.application.interfaces.in.IListService;
import backend.application.interfaces.in.ISupplierService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.response.list.ListResponse;
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

@Path("/lists")
public class Lists {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private IListService listService;

    @Inject
    @Built
    private ISupplierService supplierService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/lots/{lotId}")
    public Response getConcurrentList(@PathParam("lotId") Long lotId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {

            return Response.ok(new ListResponse(listService.getListByLotId(lotId))).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/lots/{lotId}/suppliers/{supplierEmail}")
    public Response getConcurrentListForSupplier(@PathParam("lotId") Long lotId,
            @PathParam("supplierEmail") String supplierEmail) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            SupplierDto supplierDto = supplierService.getSupplierByEmail(supplierEmail);

            if (supplierDto == null) {
                return Response.status(404).entity("No such supplier").build();
            }

            return Response.ok(new ListResponse(listService.getListByLotIdForSupplier(lotId, supplierDto))).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

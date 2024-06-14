package backend.infrastructure.in.rest.path;

import backend.application.interfaces.in.ITypeOfBusinessService;
import backend.infrastructure.builder.Built;
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

@Path("/typesOfBusiness")
public class TypesOfBusiness {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private ITypeOfBusinessService typeOfBusinessService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSupplierData(@PathParam("supplierId") Long supplierId) {

        try {

            return Response.ok(typeOfBusinessService.getAllTypeOfBusinesses()).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

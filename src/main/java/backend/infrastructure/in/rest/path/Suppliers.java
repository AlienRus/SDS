package backend.infrastructure.in.rest.path;

import backend.infrastructure.in.rest.interceptor.TokenRequired;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{supplierId}")
    public Response getSupplierData(@PathParam("supplierId") int supplierId) {
        return Response.status(Response.Status.OK).entity("{\"supplierId\": " + supplierId + ", \"name\": \"Supplier Name\", \"address\": \"Supplier Address\"}").build();
    }
}

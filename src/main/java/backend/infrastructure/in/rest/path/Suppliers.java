package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.SupplierDto;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.repository.db.supplier.SupplierRepository;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
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
    private SupplierRepository supplierRepository;

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
            List<SupplierDto> supplierDtos = supplierRepository.getAllSuppliers();
            List<JsonObject> dataJson = new ArrayList<JsonObject>();
            for (SupplierDto supplierDto : supplierDtos) {
                JsonObjectBuilder builder = Json.createObjectBuilder()
                        .add("email", getValueOrEmpty(supplierDto.getEmail()))
                        .add("typeOfBusiness",
                                getValueOrEmpty(supplierDto.getTypeOfBusiness() != null
                                        ? supplierDto.getTypeOfBusiness().getTypeName()
                                        : null))
                        .add("company", getValueOrEmpty(supplierDto.getCompany()))
                        .add("firstName", getValueOrEmpty(supplierDto.getFirstName()))
                        .add("lastName", getValueOrEmpty(supplierDto.getLastName()))
                        .add("middleName", getValueOrEmpty(supplierDto.getMiddleName()))
                        .add("phoneNumber", getValueOrEmpty(supplierDto.getPhoneNumber()))
                        .add("regionOrAddress", getValueOrEmpty(supplierDto.getRegionOrAddress()))
                        .add("site", getValueOrEmpty(supplierDto.getSite()))
                        .add("inn", supplierDto.getInn())
                        .add("kpp", supplierDto.getKpp());

                dataJson.add(builder.build());
            }

            return Response.ok(dataJson).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    private String getValueOrEmpty(String value) {
        return value != null ? value : "";
    }
}

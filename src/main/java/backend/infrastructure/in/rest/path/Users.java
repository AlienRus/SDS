package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.application.dto.StaffDto;
import backend.application.dto.SupplierDto;
import backend.application.dto.SupplySpecialistDto;
import backend.application.interfaces.in.IStaffService;
import backend.application.interfaces.in.ISupplierService;
import backend.application.interfaces.in.ISupplySpecialistService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.in.rest.request.put.user.UpdateUserRequest;
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

@Path("/users")
public class Users {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private ISupplierService supplierService;

    @Inject
    @Built
    private ISupplySpecialistService supplySpecialistService;

    @Inject
    @Built
    private IStaffService staffService;

    private Jsonb jsonb = JsonbBuilder.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response getAllUsers() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            List<SupplierDto> suppliers = new ArrayList<>();
            List<SupplySpecialistDto> supplySpecialists = new ArrayList<>();
            List<StaffDto> staff = new ArrayList<>();
            Map<String, List> users = new HashMap<>();

            suppliers.addAll(supplierService.getAllSuppliers());
            supplySpecialists.addAll(supplySpecialistService.getAllSupplySpecialists());
            staff.addAll(staffService.getAllStaff());

            for (SupplierDto supplier : suppliers) {
                supplier.setPassword(null);
            }

            for (SupplySpecialistDto supplySpecialist : supplySpecialists) {
                supplySpecialist.setPassword(null);
            }

            for (StaffDto staffDto : staff) {
                staffDto.setPassword(null);
            }

            users.put("suppliers", suppliers);
            users.put("supplySpecialists", supplySpecialists);
            users.put("staff", staff);

            return Response.ok(users).build();
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
    @Path("/{userId}/roles/{roleName}")
    public Response updateUser(@PathParam("userId") Long userId, @PathParam("roleName") String roleName,
            String userDataJSON) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {

            UpdateUserRequest updateUserRequest = jsonb.fromJson(userDataJSON, UpdateUserRequest.class);

            if (roleName.equals("supplier")) {

                SupplierDto supplierDto = supplierService.getSupplierById(userId);

                if (updateUserRequest.getCompany() != null) {
                    supplierDto.setCompany(updateUserRequest.getCompany());
                }

                if (updateUserRequest.getEmail() != null) {
                    supplierDto.setEmail(updateUserRequest.getEmail());
                }

                if (updateUserRequest.getFirstName() != null) {
                    supplierDto.setFirstName(updateUserRequest.getFirstName());
                }

                if (updateUserRequest.getInn() != null) {
                    supplierDto.setInn(updateUserRequest.getInn());
                }

                if (updateUserRequest.getKpp() != null) {
                    supplierDto.setKpp(updateUserRequest.getKpp());
                }

                if (updateUserRequest.getLastName() != null) {
                    supplierDto.setLastName(updateUserRequest.getLastName());
                }

                if (updateUserRequest.getMiddleName() != null) {
                    supplierDto.setMiddleName(updateUserRequest.getMiddleName());
                }

                if (updateUserRequest.getPassword() != null) {
                    supplierDto.setPassword(updateUserRequest.getPassword());
                }

                if (updateUserRequest.getNds() != null) {
                    supplierDto.setNds(updateUserRequest.getNds());
                }

                if (updateUserRequest.getPhoneNumber() != null) {
                    supplierDto.setPhoneNumber(updateUserRequest.getPhoneNumber());
                }

                if (updateUserRequest.getRegionOrAddress() != null) {
                    supplierDto.setRegionOrAddress(updateUserRequest.getRegionOrAddress());
                }

                if (updateUserRequest.getSite() != null) {
                    supplierDto.setSite(updateUserRequest.getSite());
                }

                supplierService.updateSupplier(supplierDto);

                return Response.ok().build();

            } else if (roleName.equals("supplySpecialist")) {

                SupplySpecialistDto supplySpecialistDto = supplySpecialistService.getSupplySpecialistById(userId);
                if (supplySpecialistDto == null) {
                    return Response.status(404).entity("No such user").build();
                }

                if (updateUserRequest.getEmail() != null) {
                    supplySpecialistDto.setEmail(updateUserRequest.getEmail());
                }

                if (updateUserRequest.getPassword() != null) {
                    supplySpecialistDto.setPassword(updateUserRequest.getPassword());
                }

                if (updateUserRequest.getCompany() != null) {
                    supplySpecialistDto.setCompany(updateUserRequest.getCompany());
                }

                supplySpecialistService.updateSupplySpecialist(supplySpecialistDto);

                return Response.ok().build();

            } else if (roleName.equals("admin")) {
                StaffDto staffDto = staffService.getStaffById(userId);
                if (staffDto == null) {
                    return Response.status(404).entity("No such user").build();
                }

                if (updateUserRequest.getEmail() != null) {
                    staffDto.setEmail(updateUserRequest.getEmail());
                }

                if (updateUserRequest.getPassword() != null) {
                    staffDto.setPassword(updateUserRequest.getPassword());
                }

                staffService.updateStaff(staffDto);

                return Response.ok().build();

            } else if (roleName.equals("securitySpecialist")) {
                StaffDto staffDto = staffService.getStaffById(userId);
                if (staffDto == null) {
                    return Response.status(404).entity("No such user").build();
                }

                if (updateUserRequest.getEmail() != null) {
                    staffDto.setEmail(updateUserRequest.getEmail());
                }

                if (updateUserRequest.getPassword() != null) {
                    staffDto.setPassword(updateUserRequest.getPassword());
                }

                staffService.updateStaff(staffDto);

                return Response.ok().build();
            } else {
                return Response.status(404).entity("No such role").build();
            }

        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @DELETE
    @TokenRequired
    @Path("/{userId}/roles/{roleName}")
    public Response deleteUser(@PathParam("userId") Long userId, @PathParam("roleName") String roleName) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {

            if (roleName.equals("supplier")) {
                SupplierDto supplierDto = supplierService.getSupplierById(userId);
                supplierService.deleteSupplier(supplierDto);

                return Response.ok().build();

            } else if (roleName.equals("supplySpecialist")) {
                SupplySpecialistDto supplySpecialistDto = supplySpecialistService.getSupplySpecialistById(userId);
                supplySpecialistService.deleteSupplySpecialist(supplySpecialistDto);

                return Response.ok().build();

            } else if (roleName.equals("admin")) {
                StaffDto staffDto = staffService.getStaffById(userId);
                staffService.deleteStaff(staffDto);

                return Response.ok().build();

            } else if (roleName.equals("securitySpecialist")) {
                StaffDto staffDto = staffService.getStaffById(userId);
                staffService.deleteStaff(staffDto);

                return Response.ok().build();
            }

            return Response.status(404).entity("No such user with given role").build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

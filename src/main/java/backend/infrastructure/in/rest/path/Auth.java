package backend.infrastructure.in.rest.path;

import backend.application.dto.RoleDto;
import backend.application.dto.StaffDto;
import backend.application.dto.SupplierDto;
import backend.application.dto.SupplySpecialistDto;
import backend.application.dto.TypeOfBusinessDto;
import backend.application.interfaces.in.IGroupEtService;
import backend.application.interfaces.in.IRoleService;
import backend.application.interfaces.in.IStaffService;
import backend.application.interfaces.in.ISupplierService;
import backend.application.interfaces.in.ISupplySpecialistService;
import backend.application.interfaces.in.ITypeOfBusinessService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.request.AuthUserRequestDto;
import backend.infrastructure.in.rest.request.NewUserRequestDto;
import backend.infrastructure.in.rest.token.ITokenManager;
import backend.infrastructure.out.response.AuthUserResponse;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class Auth {

    @Inject
    private ITokenManager tokenManager;

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
    private IGroupEtService groupEtService;

    @Inject
    @Built
    private IRoleService roleService;

    @Inject
    @Built
    private ITypeOfBusinessService typeOfBusinessService;

    @Inject
    @Built
    private IStaffService staffService;

    private Jsonb jsonb = JsonbBuilder.create();

    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response auth(String userDataJSON) {
        try {

            AuthUserRequestDto authUserRequestDto = jsonb.fromJson(userDataJSON, AuthUserRequestDto.class);
            String email = authUserRequestDto.getEmail();
            String password = authUserRequestDto.getPassword();

            // Проверка пользователя в сервисах
            SupplierDto supplier = supplierService.getSupplierByEmailAndPassword(email, password);
            SupplySpecialistDto supplySpecialist = supplySpecialistService.getSupplySpecialistByEmailAndPassword(email,
                    password);
            StaffDto staff = staffService.getStaffByEmailAndPassword(email, password);

            // Если пользователь не найден ни в одном из сервисов, 401
            if (supplier == null && supplySpecialist == null && staff == null) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }

            // Если пользователь найден в supplierService
            if (supplier != null) {
                String token = tokenManager.generateToken(email, "supplier");
                return Response.ok(new AuthUserResponse(token, email, "supplier", supplier.getId())).build();
            }

            // Если пользователь найден в supplySpecialistService
            if (supplySpecialist != null) {
                String token = tokenManager.generateToken(email, "supplySpecialist");
                return Response.ok(new AuthUserResponse(token, email, "supplySpecialist", supplySpecialist.getId()))
                        .build();
            }

            if (staff != null) {
                String token = tokenManager.generateToken(email, staff.getRole().getRoleName());
                return Response.ok(new AuthUserResponse(token, email, staff.getRole().getRoleName(), staff.getId()))
                        .build();
            }

            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @POST
    @Path("/reg")
    @Consumes("application/json")
    @Produces("application/json")
    public Response register(String newUserJSON) {
        try {
            NewUserRequestDto newUserRequestDto = jsonb.fromJson(newUserJSON, NewUserRequestDto.class);

            String role = newUserRequestDto.getRole();

            if (role.equals("supplier")) {
                RoleDto roleDto = roleService.getRoleByName("Supplier");
                TypeOfBusinessDto typeOfBusinessDto = typeOfBusinessService
                        .getTypeOfBusinessById(newUserRequestDto.getTypeOfBusinessId());
                SupplierDto supplierDto = new SupplierDto(roleDto, newUserRequestDto.getEmail(),
                        newUserRequestDto.getPassword(), typeOfBusinessDto, newUserRequestDto.getCompany(),
                        newUserRequestDto.getFirstName(), newUserRequestDto.getMiddleName(),
                        newUserRequestDto.getLastName(), newUserRequestDto.getPhoneNumber(),
                        newUserRequestDto.getRegionOrAddress(), newUserRequestDto.getNds(), newUserRequestDto.getSite(),
                        newUserRequestDto.getInn(), newUserRequestDto.getKpp(), false);

                supplierService.createSupplier(supplierDto);

                return Response.ok().build();

            } else if (role.equals("supplySpecialist")) {
                RoleDto roleDto = roleService.getRoleByName("Supply_specialist");

                SupplySpecialistDto supplySpecialistDto = new SupplySpecialistDto(roleDto, newUserRequestDto.getEmail(),
                        newUserRequestDto.getPassword(), newUserRequestDto.getCompany(), false);

                supplySpecialistService.createSupplySpecialist(supplySpecialistDto);

                return Response.ok().build();

            } else if (role.equals("admin")) {
                RoleDto roleDto = roleService.getRoleByName("Admin");

                StaffDto staffDto = new StaffDto(newUserRequestDto.getEmail(), newUserRequestDto.getPassword(),
                        roleDto);

                staffService.createStaff(staffDto);

                return Response.ok().build();

            } else if (role.equals("securitySpecialist")) {
                RoleDto roleDto = roleService.getRoleByName("Security_specialist");

                StaffDto staffDto = new StaffDto(newUserRequestDto.getEmail(), newUserRequestDto.getPassword(),
                        roleDto);

                staffService.createStaff(staffDto);

                return Response.ok().build();
            }

            return Response.status(400).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

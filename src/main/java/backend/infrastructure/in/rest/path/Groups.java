package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.GroupEtDto;
import backend.application.dto.GroupEtsSignerDto;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.repository.db.groupET.GroupEtRepository;
import backend.infrastructure.out.repository.db.groupEtsSigner.GroupEtsSignerRepository;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
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

@Path("/groups")
public class Groups {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    private GroupEtRepository groupEtRepository;

    @Inject
    private GroupEtsSignerRepository groupEtsSignerRepository;

    private Jsonb jsonb = JsonbBuilder.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response getGroups() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            List<GroupEtDto> groups = groupEtRepository.getAllGroupEts();
            List<JsonObject> groupsJSON = new ArrayList<JsonObject>();
            for (GroupEtDto groupDto : groups) {
                List<GroupEtsSignerDto> signerDto = groupEtsSignerRepository
                        .getAllGroupEtsSignersByGroupEtsId(groupDto.getId());
                JsonObject jsonObject = Json.createObjectBuilder()
                        .add("name", groupDto.getGroupName())
                        .add("managerPost", groupDto.getManagerPost())
                        .add("managerFirstName", groupDto.getManagerFirstName())
                        .add("managerLastName", groupDto.getManagerLastName())
                        .add("managerMiddleName", groupDto.getManagerMiddleName())
                        .add("signer", jsonb.toJson(signerDto))
                        .build();
                groupsJSON.add(jsonObject);
            }
            return Response.ok(groupsJSON).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response addGroup(String requestBody) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            GroupEtDto group = jsonb.fromJson(requestBody, GroupEtDto.class);
            groupEtRepository.createGroupEt(group);
            return Response.status(201).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response updateGroup(String requestBody) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            GroupEtDto group = jsonb.fromJson(requestBody, GroupEtDto.class);
            groupEtRepository.updateGroupEt(group);
            return Response.status(201).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @DELETE
    @TokenRequired
    @Path("/{groupId}")
    public Response deleteGroup(@PathParam("groupId") Long groupId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            GroupEtDto group = groupEtRepository.getGroupEtById(groupId);
            groupEtRepository.deleteGroupEt(group);
            return Response.status(201).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

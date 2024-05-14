package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.GroupEtDto;
import backend.application.dto.GroupEtsSignerDto;
import backend.application.interfaces.in.IGroupEtService;
import backend.application.interfaces.in.IGroupEtsSignerService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.out.response.GroupResponse;
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

@Path("/groups")
public class Groups {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private IGroupEtService groupEtService;

    @Inject
    @Built
    private IGroupEtsSignerService groupEtsSignerService;

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
            List<GroupEtDto> groups = groupEtService.getAllGroupEts();

            List<GroupResponse> responses = new ArrayList<GroupResponse>();

            for (GroupEtDto group : groups) {
                List<GroupEtsSignerDto> signers = groupEtsSignerService.getAllGroupEtsSignersByGroupEtsId(group.getId());

                responses.add(new GroupResponse(group, signers));
            }

            return Response.ok(responses).build();

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
            groupEtService.createGroupEt(group);
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
            groupEtService.updateGroupEt(group);
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
            GroupEtDto group = groupEtService.getGroupEtById(groupId);
            groupEtService.deleteGroupEt(group);
            return Response.status(201).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}

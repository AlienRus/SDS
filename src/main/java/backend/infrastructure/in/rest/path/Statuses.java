package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.StatusDto;
import backend.application.interfaces.in.IStatusService;
import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.inject.Inject;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/statuses")
public class Statuses {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private IStatusService statusService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response getStatuses() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {

            List<StatusDto> statusDtos = statusService.getAllStatuses();

            List<String> responses = new ArrayList<String>();

            for (StatusDto statusDto : statusDtos) {
                responses.add(statusDto.getStatusName());
            }

            return Response.ok(responses).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}

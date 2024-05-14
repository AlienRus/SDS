package backend.infrastructure.in.rest.path;

import backend.infrastructure.in.rest.interceptor.TokenRequired;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response getAllUsers() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            JsonArrayBuilder usersArrayBuilder = Json.createArrayBuilder();

            // Пользователь 1
            JsonObjectBuilder user1Builder = Json.createObjectBuilder()
                    .add("id", 1)
                    .add("email", "alienrus@mail.ru")
                    .add("password", "1351qwaser")
                    .add("typeOfBusiness", "МСП")
                    .add("company", "Сибирские буйволы")
                    .add("firstName", "Василий")
                    .add("lastName", "Петров")
                    .add("middleName", "Иванович")
                    .add("phoneNumber", "8 900 555 3535")
                    .add("regionOrAddress", "Сибирь")
                    .add("site", "https://buivol.com")
                    .add("inn", 123456789012L)
                    .add("kpp", 123456789L)
                    .add("groupEtsId", Json.createArrayBuilder().add(1).add(2))
                    .add("groupEts",
                            Json.createArrayBuilder().add("Электродвигатели").add("Электротехническая продукция"))
                    .add("isApproved", true);

            // Пользователь 2
            JsonObjectBuilder user2Builder = Json.createObjectBuilder()
                    .add("id", 2)
                    .add("email", "example@mail.ru")
                    .add("password", "qwaser123")
                    .add("typeOfBusiness", "МСП")
                    .add("company", "Леруа")
                    .add("firstName", "Максим")
                    .add("lastName", "Дзюба")
                    .add("middleName", "Иванович")
                    .add("phoneNumber", "8 923 521 03 13")
                    .add("regionOrAddress", "г. Кемерово")
                    .add("site", "")
                    .add("inn", 123456789987L)
                    .add("kpp", 123456788L)
                    .add("groupEtsId", Json.createArrayBuilder().add(1))
                    .add("groupEts", Json.createArrayBuilder().add("Электродвигатели"))
                    .add("isApproved", true);

            // Добавление пользователей в массив
            usersArrayBuilder.add(user1Builder);
            usersArrayBuilder.add(user2Builder);

            return Response.ok(usersArrayBuilder.build()).build();
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
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") int userId, String userDataJSON) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"User updated successfully\"}").build();
    }

    @DELETE
    @TokenRequired
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") int userId) {
        return Response.status(Response.Status.OK).entity("{\"message\": \"User deleted successfully\"}").build();
    }
}

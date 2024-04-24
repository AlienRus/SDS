// package backend.infrastructure.in.rest.path;

// import java.util.HashMap;
// import java.util.Map;

// import backend.application.implementation.authentication.User;
// import backend.application.interfaces.in.authentication.IAuthorizer;
// import backend.application.interfaces.in.registration.IRegistrator;
// // import backend.application.interfaces.out.messaging.Interconnectable;
// import backend.infrastructure.builder.Built;
// import backend.infrastructure.in.rest.token.ITokenManager;
// import jakarta.inject.Inject;
// import jakarta.json.bind.Jsonb;
// import jakarta.json.bind.JsonbBuilder;
// import jakarta.json.bind.JsonbException;
// import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.container.ContainerRequestContext;
// import jakarta.ws.rs.core.Context;
// import jakarta.ws.rs.core.Response;

// @Path("/auth")
// public class Auth {
//     // application begin
//     @Inject
//     @Built
//     private IAuthorizer authorizer;

//     @Inject
//     @Built
//     private IRegistrator registrator;

//     @Inject
//     private ITokenManager tokenManager;

//     @Context
//     private ContainerRequestContext requestContext;

//     // @Inject
//     // private Interconnectable interconnector;

//     @POST
//     @Path("/login")
//     @Consumes("application/json")
//     @Produces("application/json")
//     public Response auth(String loginPasswordJSON) {
//         Jsonb jsonb = JsonbBuilder.create();
//         User user;
//         String token;
//         String resultJSON;
//         String userRole = "";

//         try {
//             try {
//                 user = jsonb.fromJson(loginPasswordJSON, User.class);
//                 token = requestContext.getHeaderString("Token");
//                 if (token == null || token.equals("") || token.equals("undefined")
//                         || token.length() != ITokenManager.TOKEN_LENGTH) { // if user doesnt have token
//                     if (!authorizer.authorize(user)) { // if invalid login/password
//                         return Response.status(Response.Status.UNAUTHORIZED).build();
//                     }

//                     userRole = authorizer.getUserRole(user);
//                     if (userRole == null || userRole.equals("")) {
//                         return Response.status(Response.Status.UNAUTHORIZED).build();
//                     }

//                     // authorized
//                     token = tokenManager.generateToken(user.getLogin(), userRole);

//                 } else {
//                     // user has token
//                     // check if token is correct
//                     if (!tokenManager.checkToken(token)) { // if invalid token
//                         return Response.status(Response.Status.UNAUTHORIZED).build();
//                     }
//                 }
//             } catch (Exception e) {
//                 return Response.status(Response.Status.UNAUTHORIZED).build();
//             }

//             Map<String, String> tokenAndRole = new HashMap<>();
//             tokenAndRole.put("token", token);
//             tokenAndRole.put("role", userRole);

//             resultJSON = jsonb.toJson(tokenAndRole);

//         } catch (JsonbException e) {
//             return Response.status(Response.Status.UNAUTHORIZED).build();
//         } catch (Exception e) {
//             return Response.status(Response.Status.BAD_REQUEST).build();
//         }
//         return Response.ok(resultJSON).build(); // send token
//     }

//     @POST
//     @Path("/reg")
//     @Consumes("application/json")
//     @Produces("application/json")
//     public Response register(String loginPasswordJSON) {
//         Jsonb jsonb = JsonbBuilder.create();
//         User user;

//         try {
//             try {
//                 user = jsonb.fromJson(loginPasswordJSON, User.class);
//                 user.setRole("user");
//             } catch (JsonbException e) {
//                 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//             }

//             if (!registrator.register(user)) {
//                 return Response.status(Response.Status.BAD_REQUEST).build();
//             }
//         } catch (JsonbException e) {
//             return Response.status(Response.Status.BAD_REQUEST).build();
//         } catch (Exception e) {
//             return Response.status(Response.Status.BAD_REQUEST).build();
//         }
//         return Response.ok().build();
//     }
// }

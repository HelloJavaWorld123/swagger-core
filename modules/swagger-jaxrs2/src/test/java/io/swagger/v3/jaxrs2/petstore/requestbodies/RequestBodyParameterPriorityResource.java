package io.swagger.v3.jaxrs2.petstore.requestbodies;

import io.swagger.v3.jaxrs2.resources.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Resource with RequestBody inside Operation and another in Method
 * Created by rafaellopez on 11/26/17.
 */
public class RequestBodyParameterPriorityResource {
    @POST
    @Path("/user")
    @Operation(summary = "Create user",
            description = "This can only be done by the logged in user.",
            requestBody = @RequestBody(description = "Inside Operation"))
    @RequestBody(description = "On method")
    public Response methodWithRequestBodyAndTwoParameters(
            @RequestBody(description = "Created user object inside Parameter", required = true,
                    content = @Content(
                            schema = @Schema(implementation = User.class))) User user) {
        return Response.ok().entity("").build();
    }
}

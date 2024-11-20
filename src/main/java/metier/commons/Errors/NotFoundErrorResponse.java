package metier.commons.Errors;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class NotFoundErrorResponse implements ErrorResponse {
    private String message;

    public NotFoundErrorResponse(String message) {
        this.message = message;
    }
    @Override
    public Response toResponse() {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(this)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @Override
    public String getMessage() {
        return message;
    }

}

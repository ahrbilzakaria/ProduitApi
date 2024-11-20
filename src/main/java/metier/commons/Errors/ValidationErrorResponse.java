package metier.commons.Errors;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class ValidationErrorResponse implements ErrorResponse {
    private String message;
    private List<String> details;

    @Override
    public Response toResponse() {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(this)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @Override
    public String getMessage() {
        return message;
    }
}

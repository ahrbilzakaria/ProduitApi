package metier.commons.Errors;

import jakarta.ws.rs.core.Response;

public interface ErrorResponse {
    Response toResponse();
    String getMessage();
}

package vasic.prodavnica.racunara.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, int entityId) {
        super("Entity " + entityName + " with ID: " + entityId + " not found!");
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

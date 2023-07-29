package EaseMood.com.api.exception;

import java.util.List;
public record ErrorResponse(int status, String message, List<String> errors) {
    // No need to explicitly define constructors, getters, or any other methods
    // The record automatically generates them for us
}
package iplookup.Advice;

import feign.FeignException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handles Exceptions and provides user info on the errors
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * Handles bad requests to api
     * @param feignException exception
     * @return error info
     */
    @ExceptionHandler(FeignException.BadRequest.class)
    public String badRequest(Model model, FeignException feignException) {
        // Get error
        String error = feignException.getMessage();

        // Specify/Generalize error
        if (error.contains("Invalid IP")) {
            error = "Invalid IP Address";
        } else {
            error = "An error has occured";
        }

        // Add error
        model.addAttribute("error", error);

        // Send to error page
        return "error.html";
    }
}

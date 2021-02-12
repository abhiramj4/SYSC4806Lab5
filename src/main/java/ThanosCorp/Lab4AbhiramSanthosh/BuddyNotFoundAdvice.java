package ThanosCorp.Lab4AbhiramSanthosh;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class BuddyNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BuddyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(BuddyNotFoundException ex) {
        return ex.getMessage();
    }
}
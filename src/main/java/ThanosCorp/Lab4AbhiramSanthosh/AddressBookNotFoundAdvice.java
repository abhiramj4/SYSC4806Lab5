package ThanosCorp.Lab4AbhiramSanthosh;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AddressBookNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AddressBookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(AddressBookNotFoundException ex) {
        return ex.getMessage();
    }
}
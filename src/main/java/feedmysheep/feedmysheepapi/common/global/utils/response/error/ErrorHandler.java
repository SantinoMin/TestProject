package feedmysheep.feedmysheepapi.common.global.utils.response.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ApplicationError> handlerCustomerNotFoundException(CustomException exception, WebRequest webRequest) {

    ApplicationError error = new ApplicationError();
    error.setStatus(error.getStatus());
    error.setMessage(exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  };

}

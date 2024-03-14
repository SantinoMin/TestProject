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
public class SuccessHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ApplicationError> handlerCustomerSuccessException(CustomException exception, WebRequest webRequest) {

    ApplicationError success = new ApplicationError();
    success.setStatus("SUCCESS");
    success.setMessage(exception.getMessage());

    return new ResponseEntity<>(success, HttpStatus.OK);
  };

}

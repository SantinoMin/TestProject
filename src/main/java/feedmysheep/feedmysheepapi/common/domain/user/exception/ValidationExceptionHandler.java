package feedmysheep.feedmysheepapi.common.domain.user.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
    List<String> errors = new ArrayList<>();

    ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

    Collections.sort(errors);

//    Map<String, List<String>> result = new HashMap<>();
//    result.put("errors", errors);
//    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

    return new ResponseEntity<>(Collections.singletonMap("errors", errors), HttpStatus.BAD_REQUEST);
  }
}

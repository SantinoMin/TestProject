//package feedmysheep.feedmysheepapi.common.domain.user.exception;
//
//import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class AjaxBadResponseHandler {
//
//  @ExceptionHandler({MethodArgumentNotValidException.class})
//  public ResponseEntity<?> validException(
//      MethodArgumentNotValidException ex) {
//
//    UserResDto restReponse = new UserResDto(false, // 1
//        "유효성 검사 실패 : " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//
//    return new ResponseEntity<>(restReponse, HttpStatus.BAD_REQUEST); // 2
//  }
//}

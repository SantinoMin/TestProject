//package feedmysheep.feedmysheepapi.common.domain.user.exception;
//
//import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class BadResponseHandler {
//
//  @ExceptionHandler(JsonException.class)
//  public UserResDto jsonException(JsonException ex) {
//    return UserResDto.of(ex.getMessage());
//  }
//
//}
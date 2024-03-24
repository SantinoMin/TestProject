package feedmysheep.feedmysheepapi.common.domain.user.controller;

import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class UserController {

  //생성자 주입
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  // "/user/join의 GetMapping은 어떤식으로 작성 되어야 되지?
//  @GetMapping("/user/join")
//  public UserDto user(){
//    return this.userService.();
//  }

  // 회원가입
  @PostMapping("/user/join")
  public ResponseEntity<UserResDto> join(@Valid @RequestBody UserReqDto body) {
    return this.userService.join(body);
  }

  // 로그인
  @PostMapping("/user/login")
  public LoginUserResDto login(@RequestBody LoginUserReqDto body){
    return this.userService.login(body);
  }

}

;
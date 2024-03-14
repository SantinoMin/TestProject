package feedmysheep.feedmysheepapi.common.domain.user.controller;

import feedmysheep.feedmysheepapi.common.domain.user.dto.JoinUserDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

//  @GetMapping("/user")
//  public List<UserEntity> user(@RequestParam("id") String id){
//    return this.userService.user(id);
//  }

  @PostMapping("/user/join")
  public JoinUserDto join(@RequestBody UserReqDto.joinUser body) {
    return this.userService.join(body);
  }
}

;
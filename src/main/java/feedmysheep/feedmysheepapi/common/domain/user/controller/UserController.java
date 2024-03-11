package feedmysheep.feedmysheepapi.common.domain.user.controller;

import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto.joinUser;
import feedmysheep.feedmysheepapi.common.domain.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user/join")
  public joinUser join(@Valid @RequestBody UserReqDto.joinUser body) {
    return this.userService.join(body);
  }
}

;
package feedmysheep.feedmysheepapi.common.domain.signUp.controller;

import feedmysheep.feedmysheepapi.common.domain.signUp.dto.SignUpDto;
import feedmysheep.feedmysheepapi.common.domain.signUp.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class SignUpController {

  private final SignUpService signUpService;
@Autowired
public SignUpController(SignUpService signUpService){
  this.signUpService = signUpService;
}

  @GetMapping("/member/signUp") // HTTP GET 요청에 대한 핸들러
  public SignUpDto signUp() {
    return null;
  }
  };
package feedmysheep.feedmysheepapi.common.domain.word.controller;

import feedmysheep.feedmysheepapi.common.domain.signUp.dto.SignUpDto;
import feedmysheep.feedmysheepapi.common.domain.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class WordController {

  private final WordService wordService;
  @Autowired
  public WordController(WordService wordService){
    this.wordService = wordService;
  }

  @GetMapping("/member/signUp") // HTTP GET 요청에 대한 핸들러
  public SignUpDto signUp() {
    return null;
  }
};

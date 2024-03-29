//package feedmysheep.feedmysheepapi.common.domain.word.controller;
//
//import feedmysheep.feedmysheepapi.common.domain.word.dto.WordResDto;
//import feedmysheep.feedmysheepapi.common.domain.word.service.WordService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/app")
//public class WordController {
//
//  private final WordService wordService;
//  @Autowired
//  public WordController(WordService wordService){
//    this.wordService = wordService;
//  }
//
//  @GetMapping("/word") // HTTP GET 요청에 대한 핸들러
//  public WordResDto signUp(){
//
//    return null;
//  }
//
//  @PostMapping("/word")
//  public WordResDto word(@Valid @RequestBody WordResDto body){
//    return this.wordService.word(body);
//  }
//};

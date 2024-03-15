package feedmysheep.feedmysheepapi.common.domain.member.controller;

import feedmysheep.feedmysheepapi.common.domain.member.dto.MemberDTO;
import feedmysheep.feedmysheepapi.common.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

  //생정자 주입
  private final MemberService memberService;

  @GetMapping("/member/save")
  public String saveForm(){
    return "save";
  }

  @PostMapping("/member/save")
  public String save(@ModelAttribute MemberDTO memberDto){

    memberService.save(memberDto);
    return "index";
  }
}

package feedmysheep.feedmysheepapi.common.domain.member.controller;

import feedmysheep.feedmysheepapi.common.domain.member.dto.MemberDTO;
import feedmysheep.feedmysheepapi.common.domain.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  //생성자 주입
  private final MemberService memberService;

  @GetMapping("/member/save")
  public String saveForm() {
    return "save";
  }

  @GetMapping("/member/login")
  public String loginForm() {
    return "login";
  }

  @PostMapping("/member/save")
  public String save(@ModelAttribute MemberDTO memberDTO
  ) {

    memberService.save(memberDTO);
    System.out.println("MemberController.save");
    return "login";
  }

  @PostMapping("/member/login")
  public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
    MemberDTO loginResult = memberService.login(memberDTO);
    if (loginResult != null) {
      // login 성공
//        session.setAttribute("loginName", loginResult.getMember_name());
      session.setAttribute("member_email", loginResult.getMemberEmail());
      session.setAttribute("member_name", loginResult.getMemberName());
      return "main";
    } else {
      // login 실패
      return "login";
    }
  }

  @GetMapping("/member/")
  public String findAll(Model model) {
    List<MemberDTO> memberDTOList = memberService.findAll();
    // 어떠한 html로 가져갈 데이터가 있다면 model 사용
    model.addAttribute("memberList", memberDTOList);
    return "list";
  }

  @GetMapping("/member/{id}")
  public String findById(@PathVariable Long id, Model model) {
    //조회하는 갯수가 1개냐 다수냐에 따라서 리턴타입 결정하기
    MemberDTO memberDTO = memberService.findById(id);
    model.addAttribute("member", memberDTO);
    return "detail";
  }

  @GetMapping("/member/update")
  public String updateForm(HttpSession session, Model model) {
    String myEmail = (String) session.getAttribute("login_email");
    String myName = (String) session.getAttribute("login_name");
    MemberDTO memberDTO = memberService.updateForm(myEmail, myName);
    model.addAttribute("updateMember", memberDTO);
    return "update";
  }

  @PostMapping("/member/update")
  public String update(@ModelAttribute MemberDTO memberDTO){
    memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getId();

  }

  @GetMapping("/member/delete/{id}")
  public String deleteById(@PathVariable Long id){
    memberService.deleteById(id);

    return "redirect:/member/";
  }

  @GetMapping("/member/logout")
  public String logout(HttpSession session){
    session.invalidate();
    return "index";
  }
};



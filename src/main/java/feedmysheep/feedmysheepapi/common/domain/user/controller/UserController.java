package feedmysheep.feedmysheepapi.common.domain.user.controller;

import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.LoginUserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserReqDto;
import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
import feedmysheep.feedmysheepapi.common.domain.user.service.UserService;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j // 응답을 기록하는 데 도움이 되며 주로 디버깅 목적
@RequestMapping("/app")
public class UserController {

  //생성자 주입
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  // 회원가입 페이지 출력 요청
  @GetMapping("/main")
  public String homeController() {
      return "/main";
  }
// 로그인, 회원가입시 jwt 적용 시켜서 진행?
  // 주소 찾는
  // 스크린키 생성해줘야 되는듯?


  // 회원가입
  @PostMapping("/user/join")
  public UserResDto.message join(@Valid @RequestBody UserReqDto body) {
    return this.userService.join(body);
  }

  // 로그인
  @PostMapping("/user/login")
  public  ResponseEntity<LoginUserResDto> login(@Valid @RequestBody LoginUserReqDto body){
    return this.userService.login(body);
  }

  // 휴대폰 인증
  // One-time-Password
  @GetMapping("/user/verification")
  public ResponseEntity<String> generateOTP(){
    String ACCOUNT_SID = "ACed602bb1cc232f332a34ec5849fa4ec8";
//    String AUTH_TOKEN = "6082dd82e4455d82f3f06e9679304fd5";

    Twilio.init(System.getenv("ACed602bb1cc232f332a34ec5849fa4ec8"), System.getenv("6082dd82e4455d82f3f06e9679304fd5"));

    Verification verification = Verification.creator(
            "ACed602bb1cc232f332a34ec5849fa4ec8", // this is your verification sid
            "+19896238055", //this is your Twilio verified recipient phone number
            "sms") // this is your channel type
        .create();

    System.out.println(verification.getStatus());

    log.info("OTP has been successfully generated, and awaits your verification {}", LocalDateTime.now());

    return new ResponseEntity<>("Your OTP has been sent to your verified phone number", HttpStatus.OK);
  }

  // OTP 확인하기
  @GetMapping("/user/verifyOTP")
  public ResponseEntity<?> verifyUserOTP() throws Exception {

    String ACCOUNT_SID = "ACed602bb1cc232f332a34ec5849fa4ec8";
    String AUTH_TOKEN = "6082dd82e4455d82f3f06e9679304fd5";

    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    try {

      VerificationCheck verificationCheck = VerificationCheck.creator(
              "ACed602bb1cc232f332a34ec5849fa4ec8")
          .setTo("+19896238055")
          .setCode("486578")
          .create();

      System.out.println(verificationCheck.getStatus());

    } catch (Exception e) {
      return new ResponseEntity<>("Verification failed.", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("This user's verification has been completed successfully", HttpStatus.OK);
  }

}

;
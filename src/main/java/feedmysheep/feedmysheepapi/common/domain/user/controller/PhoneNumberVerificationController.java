//package feedmysheep.feedmysheepapi.common.domain.user.controller;
//
//import com.twilio.Twilio;
//import com.twilio.rest.verify.v2.service.Verification;
//import com.twilio.rest.verify.v2.service.VerificationCheck;
//import java.time.LocalDateTime;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(path = "api/phoneNumber")
//@Slf4j // 응답을 기록하는 데 도움이 되며 주로 디버깅 목적으
//public class PhoneNumberVerificationController {
//
//  @GetMapping(value = "/generateOTP")
//  public ResponseEntity<String> generateOTP(){
//
////    String ACCOUNT_SID = "ACed602bb1cc232f332a34ec5849fa4ec8";
////    String AUTH_TOKEN = "6082dd82e4455d82f3f06e9679304fd5";
//
//    Twilio.init(System.getenv("ACed602bb1cc232f332a34ec5849fa4ec8"), System.getenv("6082dd82e4455d82f3f06e9679304fd5"));
//
//    Verification verification = Verification.creator(
//            "ACed602bb1cc232f332a34ec5849fa4ec8", // this is your verification sid
//            "+19896238055", //this is your Twilio verified recipient phone number
//            "sms") // this is your channel type
//        .create();
//
//    System.out.println(verification.getStatus());
//
//    log.info("OTP has been successfully generated, and awaits your verification {}", LocalDateTime.now());
//
//    return new ResponseEntity<>("Your OTP has been sent to your verified phone number", HttpStatus.OK);
//  }
//
//  @GetMapping("/verifyOTP")
//  public ResponseEntity<?> verifyUserOTP() throws Exception {
//
//    String ACCOUNT_SID = "ACed602bb1cc232f332a34ec5849fa4ec8";
//    String AUTH_TOKEN = "6082dd82e4455d82f3f06e9679304fd5";
//
//    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//    try {
//
//      VerificationCheck verificationCheck = VerificationCheck.creator(
//              "ACed602bb1cc232f332a34ec5849fa4ec8")
//          .setTo("+19896238055")
//          .setCode("486578")
//          .create();
//
//      System.out.println(verificationCheck.getStatus());
//
//    } catch (Exception e) {
//      return new ResponseEntity<>("Verification failed.", HttpStatus.BAD_REQUEST);
//    }
//    return new ResponseEntity<>("This user's verification has been completed successfully", HttpStatus.OK);
//  }
//}

//package feedmysheep.feedmysheepapi.common.domain.user.service;
//
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class SMSService {
//
//  @Value("${twilio.credentials.TWILIO_ACCOUNT_SID}")
//  String ACCOUNT_SID;
//
//  @Value("${twilio.credentials.TWILIO_AUTH_TOKEN}")
//  String AUTH_TOKEN;
//
//  @Value("${twilio.credentials.TWILIO_OUTGOING_SMS_NUMBER}")
//  String OUTGOING_SMS_NUMBER;
//
////  public SMSService(){
////    log.info("Creating class SMSService");
////    log.info("ACCOUNT_SID" + ACCOUNT_SID);
////
////  }
//
//  @PostConstruct
//  private void setup() {
////    log.info("ACCOUNT_SID" + ACCOUNT_SID);
//    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//  }
//
//  //아래 코드 이해하도록.
//  public String sendSMS(String smsNumber, String smsMessage) {
//
//    Message message = Message.creator(
//        new PhoneNumber(smsNumber),
//        new PhoneNumber(OUTGOING_SMS_NUMBER),
//        smsMessage).create();
//
//    return message.getStatus().toString();
//  }
//}

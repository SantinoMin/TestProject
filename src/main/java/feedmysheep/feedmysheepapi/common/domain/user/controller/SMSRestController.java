//package feedmysheep.feedmysheepapi.common.domain.user.controller;
//
//import feedmysheep.feedmysheepapi.common.domain.user.service.SMSService;
//import feedmysheep.feedmysheepapi.common.models.SMSSendRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1")
//@Slf4j
//public class SMSRestController {
//
//  @Autowired
//  SMSService smsService;
//
//  @PostMapping("/processSMS")
//  public String processSMS(@RequestBody SMSSendRequest sendRequest){
//    log.info("processSMS started sendRequest: " + sendRequest.toString());
//
//    return this.smsService.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getSmsMessages());
//  }
//
//}

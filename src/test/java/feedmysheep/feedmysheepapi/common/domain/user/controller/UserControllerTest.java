//package feedmysheep.feedmysheepapi.common.domain.user.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.web.servlet.function.RequestPredicates.contentType;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import feedmysheep.feedmysheepapi.common.domain.user.dto.UserJoinRequest;
//import feedmysheep.feedmysheepapi.common.domain.user.service.UserService;
//import java.util.Date;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//@WebMvcTest
//class UserControllerTest {
//
//  @Autowired
//  MockMvc mockMvc;
//
//  @MockBean
//  UserService userService;
//
//  @Autowired
//  ObjectMapper objectMapper;
//
//  @Test
//  @DisplayName("회원가입 성공")
//  void join() throws Exception {
//
//    String name = "santino";
//    String password = "santino1";
//    String phone = "010-1234-1234";
//    String address = "강북구 번동";
//
//    //http로 보낼 때 byte로 보내는 거라, 에러 나오면 확인 해보기
//    mockMvc.perform((post("/app/user/join")));
//    .contentType(MediaType.APPLICATION_JSON)
//        .content(
//            objectMapper.writeValueAsBytes(new UserJoinRequest(name, password, phone, address))
//                .andDo(print())
//                .andExpect(status().isOk())
//        )
//  }
//
//}
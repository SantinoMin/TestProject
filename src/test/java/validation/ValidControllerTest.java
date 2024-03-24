//package validation;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import feedmysheep.feedmysheepapi.common.domain.user.controller.UserController;
//import feedmysheep.feedmysheepapi.common.domain.user.dto.UserResDto;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//public class ValidControllerTest {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @Autowired
//  private ObjectMapper objectMapper;
//
//
//  @Test
//  public void validation_실패() throws Exception {
//    String content = objectMapper.writeValueAsString(new UserResDto(false, null));
//
//    mockMvc.perform(post("/valid")
//            .content(content)
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON))
//        .andExpect(status().is4xxClientError())
//        .andExpect(jsonPath("$.message").value("유효성 검사 실패 : 나이"))
//        .andDo(print());
//  }
//
//  @Test
//  public void validation_성공() throws Exception {
//    String content = objectMapper.writeValueAsString(new UserResDto(true, "10"));
//
//    mockMvc.perform(post("/valid")
//            .content(content)
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//        .andDo(print());
//  }
//
//}

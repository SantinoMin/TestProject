package feedmysheep.feedmysheepapi.common.swagger.register;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class RegisterController {

  @GetMapping("/test")
  public String test(){
    return "Hello, world";
  }

}

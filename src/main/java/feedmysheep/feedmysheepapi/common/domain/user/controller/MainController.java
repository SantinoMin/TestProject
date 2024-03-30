package feedmysheep.feedmysheepapi.common.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

  public String mainP(){

    return "Main Page";
  }
}

package fi.tvermila.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

  @GetMapping(value="/")
  public String getMethodName() {
      return "home";
  }
  
}
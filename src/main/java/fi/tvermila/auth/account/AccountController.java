package fi.tvermila.auth.account;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("account")
public class AccountController {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private AccountService accountService;

  @GetMapping("/registration")
  public String registrationPage(Model model) {
    AccountDto accountDto = new AccountDto();
    model.addAttribute("account", accountDto);
    return "registration";
  }

  @PostMapping("/registration")
  public String registration(@ModelAttribute("account") @Valid AccountDto accountDto) {
    try {
      accountService.registerAccount(accountDto);
    } catch (EntityExistsException e) {
      System.err.println(e.getMessage());
      return "registration";
    }

    return "home";
  }
  
}
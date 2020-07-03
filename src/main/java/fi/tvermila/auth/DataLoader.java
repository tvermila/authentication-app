package fi.tvermila.auth;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

import fi.tvermila.auth.account.AccountRepository;
import fi.tvermila.auth.role.Role;
import fi.tvermila.auth.account.Account;

@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<Account> accounts = new ArrayList<>();
    accounts.add(new Account("keke", passwordEncoder.encode("passu"), Role.USER));
    accountRepository.saveAll(accounts);

  }
}
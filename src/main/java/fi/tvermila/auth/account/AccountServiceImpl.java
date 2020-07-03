package fi.tvermila.auth.account;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public Account registerAccount(AccountDto accountDto) throws EntityExistsException {
    if (findByUsername(accountDto.getUsername()) != null) {
      throw new EntityExistsException("accountDto already exists!");
    }
    Account account = new Account();
    account.setUsername(accountDto.getUsername());
    account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
    account.setRole(accountDto.getRole());
    return accountRepository.save(account);
  }

  @Override
  public Account findByUsername(String username) {
    return accountRepository.findByUsername(username);
  }
  
}
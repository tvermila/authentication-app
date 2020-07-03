package fi.tvermila.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.tvermila.auth.account.Account;
import fi.tvermila.auth.account.AccountRepository;

import org.springframework.security.core.userdetails.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private AccountRepository accountRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account account = accountRepository.findByUsername(username);
    if (account == null) {
      throw new UsernameNotFoundException(username);
    }
    UserDetails userDetails = User.withUsername(account.getUsername())
        .password(account.getPassword()).roles(account.getRole().name()).build();
    return userDetails;
  }

}
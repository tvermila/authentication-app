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
  AccountRepository accountRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account user = accountRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword())
        .authorities(user.getRole().name()).build();
    return userDetails;
  }

}
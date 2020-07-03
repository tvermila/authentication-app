package fi.tvermila.auth.account;

import javax.persistence.EntityExistsException;

public interface AccountService {
  Account registerAccount(AccountDto accountDto) throws EntityExistsException;

  Account findByUsername(String username);
  
}
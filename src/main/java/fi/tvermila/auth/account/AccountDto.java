package fi.tvermila.auth.account;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fi.tvermila.auth.role.Role;
import lombok.Data;

@Data
public class AccountDto {

  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String password;
  private String matchingPassword;

  private Role role = Role.USER;
}
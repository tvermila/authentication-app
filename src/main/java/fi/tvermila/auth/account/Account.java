package fi.tvermila.auth.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fi.tvermila.auth.role.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Account {  

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  @NonNull
  private String username;

  @Column(nullable = false)
  @NonNull
  private String password;

  @Column(nullable = true)
  private String firstname;

  @Column(nullable = true)
  private String lastname;

  @Column(nullable = true)
  private String email;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  @NonNull
  private Role role;

  @Column(nullable = false)
  private Boolean enabled = false;

  @Column(nullable = false)
  private Date dateCreated = new Date();

}
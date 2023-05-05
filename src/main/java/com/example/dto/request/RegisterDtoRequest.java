package com.example.dto.request;

public class RegisterDtoRequest {
  private String login;
  private String firstname;
  private String lastname;
  private String email;
  private String password;

  public RegisterDtoRequest() {
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RegisterDtoRequest that)) return false;

    if (getLogin() != null ? !getLogin().equals(that.getLogin()) : that.getLogin() != null) return false;
    if (getFirstname() != null ? !getFirstname().equals(that.getFirstname()) : that.getFirstname() != null)
      return false;
    if (getLastname() != null ? !getLastname().equals(that.getLastname()) : that.getLastname() != null) return false;
    if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
    return getPassword() != null ? getPassword().equals(that.getPassword()) : that.getPassword() == null;
  }

  @Override
  public int hashCode() {
    int result = getLogin() != null ? getLogin().hashCode() : 0;
    result = 31 * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
    result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    return result;
  }
}

package com.example.dto.response;

public class AuthenticationDtoResponse {
  private String token;

  public AuthenticationDtoResponse() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AuthenticationDtoResponse response)) return false;

    return getToken() != null ? getToken().equals(response.getToken()) : response.getToken() == null;
  }

  @Override
  public int hashCode() {
    return getToken() != null ? getToken().hashCode() : 0;
  }
}

package com.example.model;

import jakarta.persistence.*;

@Entity
public class Token {

  @Id
  @GeneratedValue
  public Long id;

  @Column(name = "token", unique = true)
  public String token;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  @Column(name = "revoked")
  public boolean revoked;

  @Column(name = "expired")
  public boolean expired;

  @ManyToOne
  @JoinColumn(name = "user_id")
  public User user;

  public Token() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public TokenType getTokenType() {
    return tokenType;
  }

  public void setTokenType(TokenType tokenType) {
    this.tokenType = tokenType;
  }

  public boolean isRevoked() {
    return revoked;
  }

  public void setRevoked(boolean revoked) {
    this.revoked = revoked;
  }

  public boolean isExpired() {
    return expired;
  }

  public void setExpired(boolean expired) {
    this.expired = expired;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Token)) return false;

    Token token1 = (Token) o;

    if (isRevoked() != token1.isRevoked()) return false;
    if (isExpired() != token1.isExpired()) return false;
    if (getId() != null ? !getId().equals(token1.getId()) : token1.getId() != null) return false;
    if (getToken() != null ? !getToken().equals(token1.getToken()) : token1.getToken() != null) return false;
    if (getTokenType() != token1.getTokenType()) return false;
    return getUser() != null ? getUser().equals(token1.getUser()) : token1.getUser() == null;
  }

  @Override
  public int hashCode() {
    int result = getId() != null ? getId().hashCode() : 0;
    result = 31 * result + (getToken() != null ? getToken().hashCode() : 0);
    result = 31 * result + (getTokenType() != null ? getTokenType().hashCode() : 0);
    result = 31 * result + (isRevoked() ? 1 : 0);
    result = 31 * result + (isExpired() ? 1 : 0);
    result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
    return result;
  }
}

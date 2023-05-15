package com.example.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "login", unique = true, nullable = false, length = 30)
  private String login;
  @Column(name = "firstname", nullable = false, length = 30)
  private String firstname;
  @Column(name = "middlename", length = 30)
  private String middleName;
  @Column(name = "lastname", nullable = false, length = 30)
  private String lastname;
  @Column(name = "email", unique = true, nullable = false, length = 30)
  private String email;
  @Column(name = "password", nullable = false, length = 300)
  private String password;
  @OneToMany
  private Set<User> following;
  @OneToMany
  private Set<User> ignore;
  @OneToMany(mappedBy = "user")
  private Set<Comment> comments;
  @Column(name = "role")
  @Enumerated(value = EnumType.STRING)
  private Role role;
  @OneToMany(mappedBy = "user")
  private Set<Token> tokens;
  @OneToMany(mappedBy = "user")
  private Set<Note> notes;
  @Column(name = "active")
  private Boolean isActive;

  public User() {
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
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

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<User> getFollowing() {
    if (following == null) {
      following = new HashSet<>();
    }
    return following;
  }

  public void setFollowing(Set<User> following) {
    this.following = following;
  }

  public Set<User> getIgnore() {
    if (ignore == null) {
      ignore = new HashSet<>();
    }
    return ignore;
  }

  public void setIgnore(Set<User> ignore) {
    this.ignore = ignore;
  }

  public boolean addToIgnore(User user) {
    if (!user.equals(this)) {
      return ignore.add(user);
    }
    return false;
  }

  public Set<Comment> getComments() {
    return comments;
  }

  public void setComments(Set<Comment> comments) {
    this.comments = comments;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Set<Token> getTokens() {
    return tokens;
  }

  public void setTokens(Set<Token> tokens) {
    this.tokens = tokens;
  }

  public Set<Note> getNotes() {
    return notes;
  }

  public void setNotes(Set<Note> notes) {
    this.notes = notes;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User user)) return false;

    if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
    if (login != null ? !login.equals(user.login) : user.login != null) return false;
    if (getFirstname() != null ? !getFirstname().equals(user.getFirstname()) : user.getFirstname() != null)
      return false;
    if (getMiddleName() != null ? !getMiddleName().equals(user.getMiddleName()) : user.getMiddleName() != null)
      return false;
    if (getLastname() != null ? !getLastname().equals(user.getLastname()) : user.getLastname() != null) return false;
    if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
    if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null) return false;
    if (getFollowing() != null ? !getFollowing().equals(user.getFollowing()) : user.getFollowing() != null)
      return false;
    if (getIgnore() != null ? !getIgnore().equals(user.getIgnore()) : user.getIgnore() != null) return false;
    if (getComments() != null ? !getComments().equals(user.getComments()) : user.getComments() != null) return false;
    if (getRole() != user.getRole()) return false;
    if (getTokens() != null ? !getTokens().equals(user.getTokens()) : user.getTokens() != null) return false;
    if (getNotes() != null ? !getNotes().equals(user.getNotes()) : user.getNotes() != null) return false;
    return isActive != null ? isActive.equals(user.isActive) : user.isActive == null;
  }

  @Override
  public int hashCode() {
    int result = getId() != null ? getId().hashCode() : 0;
    result = 31 * result + (login != null ? login.hashCode() : 0);
    result = 31 * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
    result = 31 * result + (getMiddleName() != null ? getMiddleName().hashCode() : 0);
    result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    result = 31 * result + (getFollowing() != null ? getFollowing().hashCode() : 0);
    result = 31 * result + (getIgnore() != null ? getIgnore().hashCode() : 0);
    result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
    result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
    result = 31 * result + (getTokens() != null ? getTokens().hashCode() : 0);
    result = 31 * result + (getNotes() != null ? getNotes().hashCode() : 0);
    result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
    return result;
  }
}

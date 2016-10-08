package com.khannedy.meteor.models;

/**
 * @author Eko Kurniawan Khannedy
 * @since 08/10/16
 */
public class User {

  private String id;

  private String password;

  public User() {
  }

  public User(String id, String password) {
    this.id = id;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id='").append(id).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append('}');
    return sb.toString();
  }
}

package com.khannedy.meteor.models;

/**
 * @author Eko Kurniawan Khannedy
 * @since 08/10/16
 */
public class Session {

  private String id;

  private User user;

  public Session() {
  }

  public Session(String id, User user) {
    this.id = id;
    this.user = user;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}

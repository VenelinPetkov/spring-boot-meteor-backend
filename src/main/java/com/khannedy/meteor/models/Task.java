package com.khannedy.meteor.models;

/**
 * @author Eko Kurniawan Khannedy
 * @since 09/10/16
 */
public class Task {

  private String id;

  private String text;

  private Boolean checked;

  public Task() {
  }

  public Task(String id, String text, Boolean checked) {
    this.id = id;
    this.text = text;
    this.checked = checked;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Boolean getChecked() {
    return checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }
}

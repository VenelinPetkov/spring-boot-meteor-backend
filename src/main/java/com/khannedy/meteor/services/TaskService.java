package com.khannedy.meteor.services;

import com.khannedy.meteor.models.Task;

import java.util.Set;

/**
 * @author Eko Kurniawan Khannedy
 * @since 09/10/16
 */
public interface TaskService {

  /**
   * Create new task
   *
   * @param text task text
   * @return task
   */
  Task create(String text);

  /**
   * Get all task
   *
   * @return all task
   */
  Set<Task> all();

  /**
   * Remove task
   *
   * @param id by id
   */
  void remove(String id);

  /**
   * Change task checked
   *
   * @param id      task id
   * @param checked checked
   */
  void checked(String id, Boolean checked);

}

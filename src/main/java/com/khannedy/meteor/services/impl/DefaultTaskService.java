package com.khannedy.meteor.services.impl;

import com.khannedy.meteor.models.Task;
import com.khannedy.meteor.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Eko Kurniawan Khannedy
 * @since 09/10/16
 */
@Service
public class DefaultTaskService implements TaskService {

  private Map<String, Task> map = new HashMap<>();

  @Override
  public Task create(String text) {
    Task task = new Task(UUID.randomUUID().toString(), text, Boolean.FALSE);
    map.put(task.getId(), task);
    return task;
  }

  @Override
  public Set<Task> all() {
    return new HashSet<>(map.values());
  }

  @Override
  public void remove(String id) {
    map.remove(id);
  }

  @Override
  public void checked(String id, Boolean checked) {
    Task task = map.get(id);
    if (task != null) {
      task.setChecked(checked);
    }
  }
}

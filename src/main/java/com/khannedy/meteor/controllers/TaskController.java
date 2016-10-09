package com.khannedy.meteor.controllers;

import com.khannedy.meteor.models.Session;
import com.khannedy.meteor.models.Task;
import com.khannedy.meteor.services.SessionService;
import com.khannedy.meteor.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

/**
 * @author Eko Kurniawan Khannedy
 * @since 09/10/16
 */
@RequestMapping(value = "/tasks")
@RestController
public class TaskController {

  private TaskService taskService;

  private SessionService sessionService;

  @Autowired
  public TaskController(TaskService taskService, SessionService sessionService) {
    this.taskService = taskService;
    this.sessionService = sessionService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> all(@RequestHeader("Session-Id") String sessionId) {
    Optional<Session> session = sessionService.get(sessionId);
    if (session.isPresent()) {
      Set<Task> tasks = taskService.all();
      return ResponseEntity.ok(tasks);
    } else {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> create(@RequestHeader("Session-Id") String sessionId,
                                       @RequestBody String text) {
    Optional<Session> session = sessionService.get(sessionId);
    if (session.isPresent()) {
      Task task = taskService.create(text);
      return ResponseEntity.ok(task);
    } else {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> remove(@PathVariable("id") String id) {
    taskService.remove(id);
    return ResponseEntity.ok("Ok");
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{id}/{checked}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> checked(@PathVariable("id") String id, @PathVariable("checked") Boolean checked) {
    taskService.checked(id, checked);
    return ResponseEntity.ok("Ok");
  }

}

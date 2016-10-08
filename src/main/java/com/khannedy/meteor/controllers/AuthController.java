package com.khannedy.meteor.controllers;

import com.khannedy.meteor.models.Session;
import com.khannedy.meteor.models.User;
import com.khannedy.meteor.services.SessionService;
import com.khannedy.meteor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Eko Kurniawan Khannedy
 * @since 08/10/16
 */
@RestController
public class AuthController {

  private UserService userService;

  private SessionService sessionService;

  @Autowired
  public AuthController(UserService userService, SessionService sessionService) {
    this.userService = userService;
    this.sessionService = sessionService;
  }

  @RequestMapping(value = "/auth/login", method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> login(@RequestBody User user) {
    Optional<User> login = userService.login(user.getId(), user.getPassword());
    if (login.isPresent()) {
      Session session = sessionService.create(login.get());
      return ResponseEntity.ok(session);
    } else {
      return ResponseEntity.badRequest().body("BadRequest");
    }
  }

}

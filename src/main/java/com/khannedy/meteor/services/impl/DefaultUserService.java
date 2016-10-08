package com.khannedy.meteor.services.impl;

import com.khannedy.meteor.models.User;
import com.khannedy.meteor.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Eko Kurniawan Khannedy
 * @since 08/10/16
 */
@Service
public class DefaultUserService implements UserService {

  @Override
  public Optional<User> login(String id, String password) {
    if (id.equals("khannedy") && password.equals("khannedy")) {
      return Optional.of(new User(id, password));
    } else {
      return Optional.empty();
    }
  }
}

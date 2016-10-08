package com.khannedy.meteor.services;

import com.khannedy.meteor.models.User;

import java.util.Optional;

/**
 * @author Eko Kurniawan Khannedy
 * @since 08/10/16
 */
public interface UserService {

  /**
   * Login login user
   *
   * @param id       user id
   * @param password user password
   * @return Some user, or None if not found
   */
  Optional<User> login(String id, String password);

}

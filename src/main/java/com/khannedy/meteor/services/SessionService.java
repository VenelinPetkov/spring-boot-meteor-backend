package com.khannedy.meteor.services;

import com.khannedy.meteor.models.Session;
import com.khannedy.meteor.models.User;

import java.util.Optional;

/**
 * @author Eko Kurniawan Khannedy
 * @since 08/10/16
 */
public interface SessionService {

  /**
   * Create new session
   *
   * @param user for user
   * @return new Session
   */
  Session create(User user);

  /**
   * Get session by id
   *
   * @param id session id
   * @return Some session or None
   */
  Optional<Session> get(String id);

}

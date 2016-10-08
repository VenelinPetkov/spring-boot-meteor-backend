package com.khannedy.meteor.services.impl;

import com.khannedy.meteor.models.Session;
import com.khannedy.meteor.models.User;
import com.khannedy.meteor.services.SessionService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Eko Kurniawan Khannedy
 * @since 08/10/16
 */
@Service
public class DefaultSessionService implements SessionService {

  private Map<String, Session> map = new HashMap<>();

  @Override
  public Session create(User user) {
    Session session = new Session(UUID.randomUUID().toString(), user);
    map.put(session.getId(), session);
    return session;
  }

  @Override
  public Optional<Session> get(String id) {
    return Optional.ofNullable(map.get(id));
  }
}

package com.efectura.task.repository.user;

import com.efectura.task.model.User;

import java.util.List;

public interface UserRepository {
    User update(User user);

    User save(User user);

    User findOne(Integer userId);

    User getBySessionId(String sessionId);

    List<User> findAll();
}

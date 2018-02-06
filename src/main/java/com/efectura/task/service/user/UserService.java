package com.efectura.task.service.user;

import com.efectura.task.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    User findOne(Integer id);

    User getBySession(String session);

    List<User> findAll();

    User update(User user);
}

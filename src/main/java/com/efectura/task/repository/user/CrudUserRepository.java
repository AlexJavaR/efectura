package com.efectura.task.repository.user;

import com.efectura.task.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CrudUserRepository extends CrudRepository<User, Integer> {
    User getBySessionId(String sessionId);
}

package com.efectura.task.repository.user;

import com.efectura.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudUserRepository extends JpaRepository<User, Integer> {
    User getBySessionId(String sessionId);
}

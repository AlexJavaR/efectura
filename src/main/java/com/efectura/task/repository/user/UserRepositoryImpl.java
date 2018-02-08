package com.efectura.task.repository.user;

import com.efectura.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final CrudUserRepository crudRepository;

    @Autowired
    public UserRepositoryImpl(CrudUserRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public User update(User user) {
        return crudRepository.save(user);
    }

    @Override
    public User save(User user) {
        return crudRepository.save(user);
    }

    @Override
    public User findOne(Integer userId) {
        return crudRepository.findOne(userId);
    }

    @Override
    public User getBySessionId(String sessionId) {
        return crudRepository.getBySessionId(sessionId);
    }

    @Override
    public List<User> findAll() {
        return crudRepository.findAll();
    }
}

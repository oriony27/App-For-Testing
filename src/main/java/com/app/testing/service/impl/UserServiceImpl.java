package com.app.testing.service.impl;

import com.app.testing.dao.UserDao;
import com.app.testing.model.User;
import com.app.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getAllUsers(int pageSize, int pageNum) {
        return userDao.findAll();
    }

    @Override
    public User createUser(User user) {
        if (userDao.findAll().stream().noneMatch(u -> u.getName().equals(user.getName()))) {
            return userDao.save(user);
        }

        return null;
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userDao.deleteById(userId);
    }
}

package com.app.testing.service.impl;

import com.app.testing.exception.impl.ValidationExceptions;
import com.app.testing.entity.User;
import com.app.testing.repository.UserRepository;
import com.app.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;


@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long id) throws ValidationExceptions.NoSuchUser {
        logger.info(MessageFormat.format("Looking for user with id {0}", id));
        return userRepository.findById(id).orElseThrow(() -> new ValidationExceptions.NoSuchUser("User doesn't exists!"));
    }

    @Override
    public List<User> getAllUsers(int pageSize, int pageNum) {
        logger.info(MessageFormat.format("Selecting all users. Limit is {0}, offset is {1}", pageSize, pageNum));
        return userRepository.findAll().stream().skip(pageNum).limit(pageSize).collect(Collectors.toList());
    }

    @Override
    public User createUser(User user) throws ValidationExceptions.UserAlreadyExists {
        if (userRepository.findAll().stream().noneMatch(u -> u.getName().equals(user.getName()))) {
            logger.info(MessageFormat.format("User with username {0} can be created", user.getName()));
            return userRepository.save(user);
        } else {
            logger.info(MessageFormat.format("User with username {0} can't be created", user.getName()));
            throw new ValidationExceptions.UserAlreadyExists(MessageFormat.format("User with name {0} already exists and can't be created!", user.getName()));
        }
    }

    @Override
    public User updateUser(User user) {
        logger.info(MessageFormat.format("Updating user with username {0}", user.getName()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long userId) {
        logger.info(MessageFormat.format("Deleting user with id {0}", userId));
        userRepository.deleteById(userId);
    }
}

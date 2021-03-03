package com.app.testing.service;

import com.app.testing.exception.impl.ValidationExceptions;
import com.app.testing.entity.User;

import java.util.List;

/**
 * User service. Designed to provide user serving operations.
 */
public interface UserService {
    /**
     * Gets user by its id.
     *
     * @param id user id.
     * @return User.
     */
    User getUserById(long id) throws ValidationExceptions.NoSuchUser;

    /**
     * Get list of users.
     * In case nothing was found, empty list is returned.
     *
     * @param limit Pagination param. Number of users to return on a page.
     * @param offset  Pagination param. Number of the page to return. Starts from 0.
     * @return List of users.
     */
    List<User> getAllUsers(int limit, int offset);

    /**
     * Creates new user. User id should be auto-generated.
     *
     * @param user User data.
     * @return Created User object.
     */
    User createUser(User user) throws ValidationExceptions.UserAlreadyExists;

    /**
     * Updates user using given data.
     *
     * @param user User data for update. Should have id set.
     * @return Updated User object.
     */
    User updateUser(User user);

    /**
     * Deletes user by its id.
     *
     * @param userId User id.
     */
    void deleteUser(long userId) throws ValidationExceptions.NoSuchUser;

}
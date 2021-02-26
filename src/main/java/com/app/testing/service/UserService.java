package com.app.testing.service;

import com.app.testing.model.User;

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
    User getUserById(long id);

    /**
     * Get list of users.
     * In case nothing was found, empty list is returned.
     *
     * @param pageSize Pagination param. Number of users to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of users.
     */
    List<User> getAllUsers(int pageSize, int pageNum);

    /**
     * Creates new user. User id should be auto-generated.
     *
     * @param user User data.
     * @return Created User object.
     */
    User createUser(User user);

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
     * @return Flag that shows whether user has been deleted.
     */
    boolean deleteUser(long userId);

}
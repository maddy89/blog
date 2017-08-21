package com.example.user;

/**
 * @author Madhawa Bandara.
 */
public interface UserRepository {
    User findUserById (String userId);

    User save (User user);
}

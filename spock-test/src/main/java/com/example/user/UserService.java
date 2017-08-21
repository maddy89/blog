package com.example.user;

/**
 * @author Madhawa Bandara.
 */
public class UserService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(String id) {
        if (id.equals("JOHNDOE")) {
            return userRepository.findUserById(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public User save(User user) {
        if (user.getUserId() == null) {
            throw new IllegalArgumentException("No user id is given");
        } else if (user.getUserId().length() < 4) {
            throw new IllegalArgumentException("invalid userId");
        }
        return userRepository.save(user);
    }
}

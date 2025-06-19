package org.service.order;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (user == null || user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("User and email cannot be null or empty.");
        }

        // Check if user with this email already exists
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists.");
        }

        // Save the new user
        return userRepository.save(user);
    }

    public Optional<User> findUserById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return Optional.empty();
        }
        return userRepository.findById(id);
    }

    public boolean deleteUser(String id) {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        Optional<User> userToDelete = userRepository.findById(id);
        if (userToDelete.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
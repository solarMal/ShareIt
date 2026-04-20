package ru.practicum.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User createUser(User user);

    Optional<User> getUserById(Long userId);

    List<User> getAllUsers();

    User UpdateUser(User user);

    void deleteUserById(Long id);

}

package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private long dynamicId = 1;

    @Override
    public User createUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user must not be null");
        }
        user.setId(dynamicId++);
        users.put(user.getId(), user);

        return user;
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User UpdateUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }


}

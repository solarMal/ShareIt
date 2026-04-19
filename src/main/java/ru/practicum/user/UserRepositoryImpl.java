package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private long dynamicId = 1;

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user must not be null");
        }
        user.setId(dynamicId++);
        users.put(user.getId(), user);

        return user;
    }
}

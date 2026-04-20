package ru.practicum.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.practicum.errorhandler.exception.CriticalException;
import ru.practicum.errorhandler.exception.UserNotFoundException;
import ru.practicum.errorhandler.exception.ValidateException;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(@Qualifier("userRepositoryImpl") UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        validation(user);
        return repository.createUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("пользователь с id" + id + " не найден"));
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    private void validation(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank() || !user.getEmail().contains("@")) {
            throw new ValidateException("имейл не может быть пустым");
        }

        for (User currentUser : repository.getAllUsers()) {
            if (Objects.equals(currentUser.getEmail(), user.getEmail())) {
                throw new CriticalException("имейл уже существует");
            }
        }
    }
}

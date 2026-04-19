package ru.practicum.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloMessageService {
    private final String message;

    @Autowired
    public HelloMessageService(@Value("${message:Hello!}") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

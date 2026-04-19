package ru.practicum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // помечает класс как java-config для контекста приложения
@EnableWebMvc  // призывает импортировать дополнительную конфигурацию для веб-приложений
@PropertySource("classpath:application.properties")
@PropertySource(value = "D:\\dev\\ShareIt\\src\\main\\resources\\application.properties",
        ignoreResourceNotFound = true) // пример для Windows
public class WebConfig {
}

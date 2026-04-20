package ru.practicum.item;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private Long ownerId;
    private String name;
    private String description;
    private boolean available;
    private String url;
    private Long requestId; //вещь добавлена в ответ на запрос
}

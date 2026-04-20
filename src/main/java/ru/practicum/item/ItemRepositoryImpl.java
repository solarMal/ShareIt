package ru.practicum.item;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, Item> items = new HashMap<>();
    private long dynamicId = 1;


    @Override
    public List<Item> findByUserId(long userId) {
        List<Item> result = items.values().stream()
                        .filter(item -> item.getOwnerId() == userId)
                        .collect(Collectors.toList());
        log.info("пользователь с id={} сохранил {} ссылок", userId, result.size());
        return result;
    }

    @Override
    public Item save(Item item) {
        item.setId(dynamicId++);
        items.put(item.getId(), item);
        log.info("item {} создан", item);
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        Item item = items.get(itemId);

        if (item != null && item.getOwnerId() == userId) {
            items.remove(itemId);
            log.info("пользователь с id={} удалил ссылку с id={}", userId, itemId);
        }
    }
}

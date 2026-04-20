package ru.practicum.item;

import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public ItemDto toItemDto(Item item) {
        if (item == null) {
            return null;
        }
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setAvailable(item.isAvailable());
        return itemDto;
    }

    public Item toItem(ItemDto itemDto) {
        if (itemDto == null) {
            return null;
        }
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setAvailable(itemDto.isAvailable());
        return item;
    }
}

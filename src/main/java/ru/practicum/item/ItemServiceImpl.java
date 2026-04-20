package ru.practicum.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.practicum.user.User;
import ru.practicum.user.UserRepository;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;
    UserRepository userRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository,
                           @Qualifier("userRepositoryImpl") UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Item addNewItem(long userId, Item item) {
        List<User> users = userRepository.getAllUsers();

        User currentUser = users.stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElse(null);

        if (currentUser == null) {
            throw new RuntimeException("User not found");
        }

        item.setOwnerId(userId);

        itemRepository.save(item);
        return item;
    }

    @Override
    public List<Item> getItems(long userId) {
        return itemRepository.findByUserId(userId);
    }

    @Override
    public void deleteItem(long userId, long itemId) {
        itemRepository.deleteByUserIdAndItemId(userId, itemId);
    }
}

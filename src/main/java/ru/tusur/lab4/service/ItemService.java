package ru.tusur.lab4.service;

import ru.tusur.lab4.entity.Item;

public interface ItemService {
    Item saveItem(Item item);

    Item getItem(Long id);

    Item changeItem(Long id, Item inputItem);

    Double getMaxPrice();

    Double getAveragePrice();

    void deleteItem(Long id);
}

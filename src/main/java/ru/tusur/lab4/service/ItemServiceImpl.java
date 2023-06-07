package ru.tusur.lab4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tusur.lab4.entity.Item;
import ru.tusur.lab4.exception.ItemNotFoundException;
import ru.tusur.lab4.repository.ItemRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItem(Long id) {
        return unwrapItem(itemRepository.findById(id));
    }

    @Override
    public Item changeItem(Long id, Item inputItem) {
        Item item = itemRepository.getOne(id);
        item.setCategory(inputItem.getCategory());
        item.setDescription(inputItem.getDescription());
        item.setName(inputItem.getName());
        item.setPrice(inputItem.getPrice());
        item.setIsbn(inputItem.getIsbn());
        return itemRepository.save(item);
    }

    @Override
    public Double getMaxPrice() {
        return itemRepository.findHighestPrice();
    }

    @Override
    public Double getAveragePrice() {
        return itemRepository.findAveragePrice();
    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }
    private Item unwrapItem(Optional<Item> item){
        if(item.isPresent()) return item.get();
        else throw new ItemNotFoundException("item not found");
    }
}

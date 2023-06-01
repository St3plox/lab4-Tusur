package ru.tusur.lab4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.tusur.lab4.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item getOne(Long id);

    @Query("SELECT max(price) FROM Item")
    Double findHighestPrice();

    @Query("SELECT AVG(price) FROM Item")
    Double findAveragePrice();
}

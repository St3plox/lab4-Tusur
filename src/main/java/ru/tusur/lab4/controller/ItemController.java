package ru.tusur.lab4.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tusur.lab4.entity.Item;
import ru.tusur.lab4.service.ItemService;


@AllArgsConstructor
@RequestMapping("/item")
@RestController
public class ItemController {

    ItemService itemService;

    @Tag(name = "Crud Operation")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
    }

    @Tag(name = "Crud Operation")
    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.CREATED);
    }

    @Tag(name = "Crud Operation")
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.OK);
    }

    @Tag(name = "Crud Operation")
    @DeleteMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/avg")
    public ResponseEntity<Double> getAvgPrice() {
        return new ResponseEntity<>(itemService.getAveragePrice(), HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<Double> getMaxPrice() {
        return new ResponseEntity<>(itemService.getMaxPrice(), HttpStatus.OK);
    }
}

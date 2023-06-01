package ru.tusur.lab4.controller;

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

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.OK);
    }

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

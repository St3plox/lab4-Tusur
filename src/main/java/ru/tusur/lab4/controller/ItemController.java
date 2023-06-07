package ru.tusur.lab4.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Возвращает продукт", description = "возращает продукт используя id")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
    }

    @Tag(name = "Crud Operation")
    @Operation(summary = "Сохраняет проlукт", description = "Сохраняет продукт, принимая json item")
    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.CREATED);
    }

    @Tag(name = "Crud Operation")
    @Operation(summary = "Обновляет продукт", description = "Обновляет продукт по заданному id")
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.OK);
    }

    @Tag(name = "Crud Operation")
    @Operation(summary = "Удаляет продукт", description = "Удаляет продукт, используя ID")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Tag(name = "Statistics")
    @Operation(summary = "Возвращает среднюю стоимость", description = "Возвращает среднюю стоимость среди всех продуктов")
    @GetMapping("/avg")
    public ResponseEntity<Double> getAvgPrice() {
        return new ResponseEntity<>(itemService.getAveragePrice(), HttpStatus.OK);
    }

    @Tag(name = "Statistics")
    @Operation(summary = "Возвращает максимальную стоимость", description = "Возвращает максимальную стоимость среди всех продуктов")
    @GetMapping("/max")
    public ResponseEntity<Double> getMaxPrice() {
        return new ResponseEntity<>(itemService.getMaxPrice(), HttpStatus.OK);
    }
}

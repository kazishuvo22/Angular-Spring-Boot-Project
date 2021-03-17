package com.example.restservice.controllers.item;

import com.example.restservice.models.item.Item;
import com.example.restservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        try {
            List<Item> items = new ArrayList<Item>();
            itemRepository.findAll().forEach(items::add);

            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") String id) {
        Optional<Item> itemData = itemRepository.findById(id);

        if (itemData.isPresent()) {
            return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        try {
            Item _item = itemRepository.save(new Item(
                    item.getItemno(),
                    item.getItemname(),
                    item.getTestsortname(),
                    item.getSamname(),
                    item.getUnitprice()
            ));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") String id, @RequestBody Item item) {
        Optional<Item> itemData = itemRepository.findById(id);

        if (itemData.isPresent()) {
            Item _item = itemData.get();

            if (item.getItemname() != null) {
                _item.setItemname(item.getItemname());
            }

            if (item.getItemno() != null) {
                _item.setItemno(item.getItemno());
            }

            if (item.getSamname() != null) {
                _item.setSamname(item.getSamname());
            }
            if (item.getTestsortname() != null) {
                _item.setTestsortname(item.getTestsortname());
            }

            if (item.getUnitprice() != null) {
                _item.setUnitprice(item.getUnitprice());
            }

            return new ResponseEntity<>(itemRepository.save(_item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/items/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") String id) {
        try {
            itemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/items")
    public ResponseEntity<HttpStatus> deleteAllItems() {
        try {
            itemRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}

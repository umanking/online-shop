package com.example.demo.shop.web;

import com.example.demo.shop.domain.Book;
import com.example.demo.shop.domain.Item;
import com.example.demo.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Andrew Han
 * @since 2019-10-05
 */
@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/items/new")
    public String createForm() {
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(Book item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

}

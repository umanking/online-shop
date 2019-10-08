package com.example.demo.shop.web;

import com.example.demo.shop.domain.Book;
import com.example.demo.shop.domain.Item;
import com.example.demo.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    // 상품 수정 폼
    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable(value = "itemId") Long itemId, Model model) {
        Item item = itemService.findById(itemId);
        model.addAttribute("item", item);
        return "items/updateItemForm";
    }

    // 상품 수정
    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("Item") Book book) {
        itemService.saveItem(book);
        return "redirect:/items";
    }

}

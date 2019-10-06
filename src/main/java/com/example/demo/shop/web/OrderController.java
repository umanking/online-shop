package com.example.demo.shop.web;

import com.example.demo.shop.domain.Item;
import com.example.demo.shop.domain.Member;
import com.example.demo.shop.service.ItemService;
import com.example.demo.shop.service.MemberService;
import com.example.demo.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Andrew Han
 * @since 2019-10-06
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    MemberService memberService;

    @Autowired
    ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam Long memberId,
                        @RequestParam Long itemId,
                        @RequestParam int count
    ) {
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";

    }
}

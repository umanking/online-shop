package com.example.demo.shop.service;

import com.example.demo.shop.domain.*;
import com.example.demo.shop.repository.MemberRepository;
import com.example.demo.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrew Han
 * @since 2019-10-05
 */
@Service
@Transactional
public class OrderService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemService itemService;

    public Long order(Long memberId, Long itemId, int count) {
        //엔티티 조회
        Optional<Member> member = memberRepository.findById(memberId);
        Item item = itemService.findById(itemId);

        // 배송정보 생성, 주문 상품 생성
        Delivery delivery = new Delivery(member.get().getAddress());
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member.get(), delivery, orderItem);
        orderRepository.save(order);
        return order.getId();
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.cancel();
    }

    public List<Order> findOrders(OrderSearch orderSearch) {

        return orderRepository.findAll(orderSearch);
    }

}

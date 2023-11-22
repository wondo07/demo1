package com.example.demo4;

import com.example.demo4.item.Repository.ItemRepository;
import com.example.demo4.item.entity.Item;
import com.example.demo4.member.Service.MemberService;
import com.example.demo4.member.entity.Member;
import com.example.demo4.order.Repository.OrderRepository;
import com.example.demo4.order.Service.OrderService;
import com.example.demo4.order.entity.Order;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class component {

    private final ItemRepository itemRepository;
    private final MemberService memberService;
    private final OrderService orderService;

    @PostConstruct
    public void post(){
        Member member1 = new Member();
        member1.setAddress("Seoul");
        member1.setName("hong gildong");
        memberService.save(member1);

        Member member2 = new Member();
        member2.setAddress("Busan");
        member2.setName("kim gildong");
        memberService.save(member2);

        Order order1 = new Order();
        member1.addOrder(order1);
        orderService.save(order1);

        Order order2 = new Order();
        member2.addOrder(order2);
        orderService.save(order2);

        Item item1 = new Item(1L, "book", 2000);
        Item item2 = new Item(2L, "pen", 1000);
        order1.addItem(item1);
        order1.addItem(item2);
        itemRepository.save(item1);
        itemRepository.save(item2);

        Item item3 = new Item(3L, "book", 3000);
        Item item4 = new Item(4L, "pen", 4000);
        order2.addItem(item3);
        order2.addItem(item4);
        itemRepository.save(item3);
        itemRepository.save(item4);




//        Member member1 = new Member();
//        member1.setAddress("Seoul");
//        member1.setName("hong gildong");
//        memberService.save(member1);
//
//        Order order1 = new Order();
//        member1.addOrder(order1);
//        orderService.save(order1);
//
//        Item item1 = new Item(2L, "itemName2", 2000);
//        order1.addItem(item1);
//        itemRepository.save(item1);
    }
}

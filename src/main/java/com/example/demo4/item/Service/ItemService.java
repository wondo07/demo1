package com.example.demo4.item.Service;

import com.example.demo4.item.Dto.ItemResponseDto;
import com.example.demo4.item.Repository.ItemRepository;
import com.example.demo4.item.entity.Item;
import com.example.demo4.member.Service.MemberService;
import com.example.demo4.member.entity.Member;
import com.example.demo4.order.Service.OrderService;
import com.example.demo4.order.entity.Order;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
//    private final MemberService memberService;
//    private final OrderService orderService;

//    @PostConstruct
//    public void post(){
//        Member member = new Member();
//        member.setAddress("Seoul");
//        member.setName("hong gildong");
//        memberService.save(member);
//
//        Order order = new Order();
//        Member member1 = memberService.verifiedMember(1L);
//        member1.addOrder(order);
//        orderService.save(order);
//
//
//        Item item = new Item(1L, "itemName1", 2000);
//        Order order1 = orderService.verifiedOrder(1L);
//        order1.addItem(item);
//        itemRepository.save(item);
//    }


    public Item verifiedItem(Long itemId){
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        return optionalItem.orElseThrow(
                () -> new RuntimeException());

    }

    public ItemResponseDto toResponseDto(Item item){
        return new ItemResponseDto(item.getItemName(), item.getItemPrice());
    }


    public ItemResponseDto get(Long itemId) {
        Item item = verifiedItem(itemId);
        return toResponseDto(item);
    }
}

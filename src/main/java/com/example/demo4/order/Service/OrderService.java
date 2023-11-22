package com.example.demo4.order.Service;

import com.example.demo4.item.Dto.ItemResponseDto;
import com.example.demo4.member.Service.MemberService;
import com.example.demo4.order.Dto.OrderResponseDto;
import com.example.demo4.order.Repository.OrderRepository;
import com.example.demo4.order.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberService memberService;


//    @PostConstruct
//    public void post(){
//        Order order = new Order();
//        Member member = memberService.verifiedMember(1L);
//        member.addOrder(order);
//        orderRepository.save(order);
//    }


    public OrderResponseDto get(Long orderId) {
        Order order = verifiedOrder(orderId);

        return toResponseDto(order);
    }

    public Order verifiedOrderWithQueryDsl(Long orderId){
        Order order = orderRepository.findByIdWithQueryDsl(orderId);
        if(order == null){
            throw new RuntimeException();
        }
        return order;
    }

    public Order verifiedOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order order = optionalOrder.orElseThrow(
                () -> new RuntimeException());
        return order;
    }

    public List<OrderResponseDto> verifiedOrderWithQueryDsls(){
        List<Order> orders = orderRepository.findByIdWithFetchs();
        return orders.stream().map(
                order -> new OrderResponseDto(order.getOrderId(),
                        order.getMember().getName(),
                        order.getMember().getAddress(),
                        order.getOrderDate(),
                        order.getItems().stream().map(
                                item -> new ItemResponseDto(item.getItemName(), item.getItemPrice())).collect(Collectors.toList()))
        ).collect(Collectors.toList());
    }

    public OrderResponseDto toResponseDto(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderId(order.getOrderId());
        orderResponseDto.setAddress(order.getMember().getAddress());
        orderResponseDto.setName(order.getMember().getName());
        orderResponseDto.setOrderDate(order.getOrderDate());

        List<ItemResponseDto> itemResponseDtos = order.getItems().stream().map(
                item -> new ItemResponseDto(item.getItemName(), item.getItemPrice())).collect(Collectors.toList());
        orderResponseDto.setItemResponseDtos(itemResponseDtos);

        return orderResponseDto;
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public List<OrderResponseDto> gets() {
        return verifiedOrderWithQueryDsls();
    }
}

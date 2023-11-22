package com.example.demo4.order.Controller;

import com.example.demo4.order.Dto.OrderResponseDto;
import com.example.demo4.order.Repository.OrderRepository;
import com.example.demo4.order.Service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    private ResponseEntity get(@PathVariable Long orderId){
        OrderResponseDto orderResponseDto= orderService.get(orderId);

        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity gets(){
        List<OrderResponseDto> orderResponseDtos = orderService.gets();
        return new ResponseEntity<>(orderResponseDtos, HttpStatus.OK);

    }


}

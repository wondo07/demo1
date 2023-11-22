package com.example.demo4.order.Dto;

import com.example.demo4.item.Dto.ItemResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class OrderResponseDto {

    private Long orderId;

    private String name;

    private String address;

    private LocalDateTime orderDate;

    private List<ItemResponseDto> itemResponseDtos;
}

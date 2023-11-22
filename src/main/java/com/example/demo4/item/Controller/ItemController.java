package com.example.demo4.item.Controller;

import com.example.demo4.item.Dto.ItemResponseDto;
import com.example.demo4.item.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    private ResponseEntity get(@PathVariable Long itemId){
        ItemResponseDto itemResponseDto = itemService.get(itemId);
        return new ResponseEntity<>(itemResponseDto, HttpStatus.OK);
    }
}

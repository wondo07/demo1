package com.example.demo4.item.entity;

import com.example.demo4.order.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column
    @Setter
    private String itemName;

    @Column
    @Setter
    private int itemPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @Setter
    @JoinColumn(name = "orderId")
    private Order order;

    public Item(Long itemId, String itemName, int itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
}

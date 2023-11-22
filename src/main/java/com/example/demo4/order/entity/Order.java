package com.example.demo4.order.entity;

import com.example.demo4.item.entity.Item;
import com.example.demo4.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId")
    @JsonIgnore
    @Setter
    private Member member;

    @Column
    @CreatedDate
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<>();


    public void addItem(Item item){
        items.add(item);
        item.setOrder(this);
    }
}

package com.example.demo4.member.entity;

import com.example.demo4.member.Repository.MemberRepository;
import com.example.demo4.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue
    private Long memberId;

    @Column
    @Setter
    private String name;

    @Column
    @Setter
    private String address;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        orders.add(order);
        order.setMember(this);
    }



}

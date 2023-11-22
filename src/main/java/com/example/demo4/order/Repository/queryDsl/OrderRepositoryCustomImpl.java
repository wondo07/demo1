package com.example.demo4.order.Repository.queryDsl;

import com.example.demo4.item.entity.QItem;
import com.example.demo4.member.entity.QMember;
import com.example.demo4.order.entity.Order;
import com.example.demo4.order.entity.QOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.demo4.order.entity.QOrder.order;

public class OrderRepositoryCustomImpl implements OrderRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public OrderRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Order findByIdWithQueryDsl(Long orderId) {
        return queryFactory
                .select(order)
                .from(order)
                .where(order.orderId.eq(orderId))
                .fetchOne();
    }

    @Override
    public Order findByIdWithFetch(Long orderId) {
        return queryFactory
                .select(order)
                .from(order)
                .join(order.member, QMember.member).fetchJoin()
                .where(order.orderId.eq(orderId))
                .fetchOne();
    }

    @Override
    public List<Order> findByIdWithFetchs() {
        return queryFactory
                .select(order)
                .from(order)
                .join(order.member, QMember.member).fetchJoin()
//                .join(order.items, QItem.item).fetchJoin()
                .fetch();

    }
}

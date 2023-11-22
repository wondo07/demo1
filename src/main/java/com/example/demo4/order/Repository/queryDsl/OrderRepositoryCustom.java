package com.example.demo4.order.Repository.queryDsl;

import com.example.demo4.order.entity.Order;

import java.util.List;

public interface OrderRepositoryCustom {

    Order findByIdWithQueryDsl(Long orderId);

    Order findByIdWithFetch(Long orderId);

    List<Order> findByIdWithFetchs();


}

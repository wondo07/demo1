package com.example.demo4.order.Repository;

import com.example.demo4.order.Repository.queryDsl.OrderRepositoryCustom;
import com.example.demo4.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom {
}

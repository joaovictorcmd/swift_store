package com.joaovictorcmd.swiftstore.repository;

import com.joaovictorcmd.swiftstore.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}

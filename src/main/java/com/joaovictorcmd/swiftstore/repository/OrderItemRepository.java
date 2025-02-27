package com.joaovictorcmd.swiftstore.repository;

import com.joaovictorcmd.swiftstore.model.entity.associations.OrderItem;
import com.joaovictorcmd.swiftstore.model.entity.associations.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}

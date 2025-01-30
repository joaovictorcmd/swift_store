package com.joaovictorcmd.swiftstore.repositories;

import com.joaovictorcmd.swiftstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joaovictorcmd
 * @date 2025 Jan 29
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}

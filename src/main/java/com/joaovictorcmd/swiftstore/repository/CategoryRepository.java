package com.joaovictorcmd.swiftstore.repository;

import com.joaovictorcmd.swiftstore.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 27
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package com.joaovictorcmd.swiftstore.model.mapper;

import com.joaovictorcmd.swiftstore.model.entity.Payment;
import com.joaovictorcmd.swiftstore.model.dto.PaymentDTO;
import org.mapstruct.Mapper;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO toDTO(Payment payment);
}

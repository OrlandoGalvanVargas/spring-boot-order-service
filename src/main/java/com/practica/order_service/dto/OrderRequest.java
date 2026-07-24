package com.practica.order_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String customerName;

    @NotNull
    @Positive(message = "El monto debe ser mayor a 0")
    private BigDecimal totalAmount;
}

package br.com.campos.pedidos.adapters.in.controller.request;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {
    private Long id;
    @NotBlank
    private String name;
    @Positive
    private double price;
}

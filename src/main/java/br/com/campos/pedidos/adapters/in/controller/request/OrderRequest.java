package br.com.campos.pedidos.adapters.in.controller.request;

import br.com.campos.pedidos.application.core.domain.OrderItem;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @Transient
    private Long id;
    @NotBlank
    private String customerName;

    @Min.List(@Min(1))
    private List<OrderItem> items;
}

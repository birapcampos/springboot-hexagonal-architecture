package br.com.campos.pedidos.adapters.out.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponse {
    private Long itemId;
    private Long productId;
    private int quantity;

    public OrderItemResponse(Long itemId, Long productId, int quantity) {
        this.itemId = itemId;
        this.productId = productId;
        this.quantity = quantity;
    }
}

package br.com.campos.pedidos.adapters.out.client.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderResponse {

    private Long orderId;
    private String customerName;
    private List<OrderItemResponse> items;
}

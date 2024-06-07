package br.com.campos.pedidos.application.ports.out.order;

import br.com.campos.pedidos.adapters.out.response.OrderResponse;

import java.util.List;
import java.util.Optional;

public interface GetOrderOutputPort {

    Optional<OrderResponse> getOrderById(Long id);
    List<OrderResponse> getAllOrders();
}

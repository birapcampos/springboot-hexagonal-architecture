package br.com.campos.pedidos.application.ports.in.order;

import br.com.campos.pedidos.adapters.out.response.OrderResponse;

import java.util.List;
import java.util.Optional;

public interface GetOrderInputPort {

    Optional<OrderResponse> getOrderById(Long id);

    List<OrderResponse> getAllOrders();

}

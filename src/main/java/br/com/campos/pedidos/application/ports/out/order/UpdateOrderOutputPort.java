package br.com.campos.pedidos.application.ports.out.order;

import br.com.campos.pedidos.adapters.out.response.OrderResponse;
import br.com.campos.pedidos.application.core.domain.Order;

public interface UpdateOrderOutputPort {

    OrderResponse updateOrder(Long id, Order updatedOrder);
}

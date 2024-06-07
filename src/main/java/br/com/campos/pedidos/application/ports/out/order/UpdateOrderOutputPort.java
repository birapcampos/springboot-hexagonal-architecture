package br.com.campos.pedidos.application.ports.out.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.response.OrderResponse;

public interface UpdateOrderOutputPort {

    OrderResponse updateOrder(Long id, OrderRequest updatedOrder);
}

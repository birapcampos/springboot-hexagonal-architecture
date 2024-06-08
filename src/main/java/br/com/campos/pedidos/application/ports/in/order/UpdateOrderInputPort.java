package br.com.campos.pedidos.application.ports.in.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.response.OrderResponse;

public interface UpdateOrderInputPort {

    OrderResponse updateOrder(Long id, OrderRequest updatedOrder);
}

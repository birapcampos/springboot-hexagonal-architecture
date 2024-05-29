package br.com.campos.pedidos.application.ports.out.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.client.response.OrderResponse;
import org.springframework.transaction.annotation.Transactional;

public interface UpdateOrderOutputPort {
    @Transactional
    OrderResponse updateOrder(Long id, OrderRequest updatedOrder);
}

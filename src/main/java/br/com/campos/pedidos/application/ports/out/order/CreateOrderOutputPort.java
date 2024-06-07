package br.com.campos.pedidos.application.ports.out.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.response.OrderResponse;
import org.springframework.transaction.annotation.Transactional;

public interface CreateOrderOutputPort {
    @Transactional
    OrderResponse createOrder(OrderRequest order);

}

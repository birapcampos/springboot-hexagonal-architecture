package br.com.campos.pedidos.application.ports.out.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.response.OrderResponse;

public interface CreateOrderOutputPort {

    OrderResponse createOrder(OrderRequest order);

}

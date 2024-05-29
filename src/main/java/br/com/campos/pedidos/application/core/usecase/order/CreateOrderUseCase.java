package br.com.campos.pedidos.application.core.usecase.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.application.ports.out.order.CreateOrderOutputPort;
import br.com.campos.pedidos.adapters.out.client.response.OrderResponse;

public class CreateOrderUseCase {

    private CreateOrderOutputPort createOrderOutputPort;

    public CreateOrderUseCase(CreateOrderOutputPort createOrderOutputPort) {
        this.createOrderOutputPort = createOrderOutputPort;
    }

    public OrderResponse createOrder(OrderRequest order) {
        return createOrderOutputPort.createOrder(order);
    }
}

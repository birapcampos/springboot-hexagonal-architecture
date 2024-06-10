package br.com.campos.pedidos.application.core.usecase.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.mapper.OrderMapper;
import br.com.campos.pedidos.adapters.out.response.OrderResponse;
import br.com.campos.pedidos.application.ports.in.order.CreateOrderInputPort;
import br.com.campos.pedidos.application.ports.out.order.CreateOrderOutputPort;

public class CreateOrderUseCase implements CreateOrderInputPort {

    private CreateOrderOutputPort createOrderOutputPort;
    private OrderMapper orderMapper;

    public CreateOrderUseCase(CreateOrderOutputPort createOrderOutputPort,
                              OrderMapper orderMapper) {
        this.createOrderOutputPort = createOrderOutputPort;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse createOrder(OrderRequest order) {

        return createOrderOutputPort.createOrder(orderMapper.toOrder(order));
    }
}

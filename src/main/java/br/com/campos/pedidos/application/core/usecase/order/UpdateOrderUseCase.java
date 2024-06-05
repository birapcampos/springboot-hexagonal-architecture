package br.com.campos.pedidos.application.core.usecase.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.application.ports.out.order.UpdateOrderOutputPort;
import br.com.campos.pedidos.adapters.out.client.response.OrderResponse;

public class UpdateOrderUseCase {

    private UpdateOrderOutputPort updateOrderOutputPort;

    public UpdateOrderUseCase(UpdateOrderOutputPort updateOrderOutputPort) {
        this.updateOrderOutputPort = updateOrderOutputPort;
    }

    public OrderResponse updateOrder(Long id, OrderRequest updatedOrder){
        return updateOrderOutputPort.updateOrder(id,updatedOrder);
    }

}
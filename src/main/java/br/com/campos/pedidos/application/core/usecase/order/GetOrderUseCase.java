package br.com.campos.pedidos.application.core.usecase.order;

import br.com.campos.pedidos.application.ports.out.order.GetOrderOutputPort;
import br.com.campos.pedidos.adapters.out.client.response.OrderResponse;

import java.util.List;
import java.util.Optional;

public class GetOrderUseCase {

    private GetOrderOutputPort getOrderOutputPort;

    public GetOrderUseCase(GetOrderOutputPort getOrderOutputPort) {

        this.getOrderOutputPort = getOrderOutputPort;
    }

    public Optional<OrderResponse> getOrderById(Long id){

        return getOrderOutputPort.getOrderById(id);
    }

    public List<OrderResponse> getAllOrders(){

        return getOrderOutputPort.getAllOrders();
    }

}

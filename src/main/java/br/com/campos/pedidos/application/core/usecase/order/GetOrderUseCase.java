package br.com.campos.pedidos.application.core.usecase.order;

import br.com.campos.pedidos.adapters.out.response.OrderResponse;
import br.com.campos.pedidos.application.ports.in.order.GetOrderInputPort;
import br.com.campos.pedidos.application.ports.out.order.GetOrderOutputPort;

import java.util.List;
import java.util.Optional;

public class GetOrderUseCase implements GetOrderInputPort {

    private GetOrderOutputPort getOrderOutputPort;

    public GetOrderUseCase(GetOrderOutputPort getOrderOutputPort) {

        this.getOrderOutputPort = getOrderOutputPort;
    }

    @Override
    public Optional<OrderResponse> getOrderById(Long id){

        return getOrderOutputPort.getOrderById(id);
    }

    @Override
    public List<OrderResponse> getAllOrders(){

        return getOrderOutputPort.getAllOrders();
    }

}

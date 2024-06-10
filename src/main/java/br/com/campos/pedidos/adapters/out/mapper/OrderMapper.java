package br.com.campos.pedidos.adapters.out.mapper;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.application.core.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest){
        return new Order(orderRequest.id(),orderRequest.customerName(),orderRequest.items());
    }

}

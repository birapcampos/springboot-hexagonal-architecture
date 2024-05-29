package br.com.campos.pedidos.application.ports.out.order;

import br.com.campos.pedidos.adapters.out.repository.OrderRepository;
import br.com.campos.pedidos.adapters.out.repository.entity.OrderEntity;
import br.com.campos.pedidos.adapters.out.client.response.OrderItemResponse;
import br.com.campos.pedidos.adapters.out.client.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GetOrderOutputPortImpl implements GetOrderOutputPort {

    private OrderRepository orderRepository;

    @Autowired
    public GetOrderOutputPortImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<OrderResponse> getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderEntity -> new OrderResponse(orderEntity.getId(), orderEntity.getCustomerName(),
                        orderEntity.getItems().stream()
                                .map(orderItemEntity -> new OrderItemResponse(
                                        orderItemEntity.getId(),
                                        orderItemEntity.getProduct().getId(),
                                        orderItemEntity.getQuantity()))
                                .collect(Collectors.toList())));
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();

        return orderEntities.stream()
                .map(orderEntity -> new OrderResponse(orderEntity.getId(), orderEntity.getCustomerName(),
                        orderEntity.getItems().stream()
                                .map(orderItemEntity -> new OrderItemResponse(orderItemEntity.getId(), orderItemEntity.getProduct().getId(), orderItemEntity.getQuantity()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}

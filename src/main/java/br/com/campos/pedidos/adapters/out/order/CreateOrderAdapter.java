package br.com.campos.pedidos.adapters.out.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.response.OrderItemResponse;
import br.com.campos.pedidos.adapters.out.response.OrderResponse;
import br.com.campos.pedidos.adapters.out.repository.OrderRepository;
import br.com.campos.pedidos.adapters.out.repository.ProductRepository;
import br.com.campos.pedidos.adapters.out.repository.entity.OrderEntity;
import br.com.campos.pedidos.adapters.out.repository.entity.OrderItemEntity;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import br.com.campos.pedidos.exceptions.ProductNotFoundException;
import br.com.campos.pedidos.application.ports.out.order.CreateOrderOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateOrderAdapter implements CreateOrderOutputPort {

    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    @Autowired
    public CreateOrderAdapter(
            ProductRepository productRepository,
            OrderRepository orderRepository) {

        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public OrderResponse createOrder(OrderRequest order) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerName(order.customerName());

        List<OrderItemEntity> orderItemEntities = order.items().stream()
                .map(orderItem -> {
                    ProductEntity productEntity = productRepository.findById(orderItem.getProduct().getId())
                            .orElseThrow(() -> new ProductNotFoundException(orderItem.getProduct().getId()
                                    .toString()));
                    return new OrderItemEntity(null, productEntity, orderItem.getQuantity(), orderEntity);
                })
                .collect(Collectors.toList());

        orderEntity.setItems(orderItemEntities);

        OrderEntity savedOrder = orderRepository.save(orderEntity);

        return new OrderResponse(savedOrder.getId(), savedOrder.getCustomerName(),
                savedOrder.getItems().stream()
                        .map(orderItemEntity -> new OrderItemResponse(
                                savedOrder.getId(),
                                orderItemEntity.getProduct().getId(),
                                orderItemEntity.getQuantity()))
                        .collect(Collectors.toList()));
    }
}

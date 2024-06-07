package br.com.campos.pedidos.adapters.out.order;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.repository.OrderRepository;
import br.com.campos.pedidos.adapters.out.repository.ProductRepository;
import br.com.campos.pedidos.adapters.out.repository.entity.OrderEntity;
import br.com.campos.pedidos.adapters.out.repository.entity.OrderItemEntity;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import br.com.campos.pedidos.application.exceptions.OrderNotFoundException;
import br.com.campos.pedidos.adapters.out.response.OrderItemResponse;
import br.com.campos.pedidos.adapters.out.response.OrderResponse;
import br.com.campos.pedidos.application.ports.out.order.UpdateOrderOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UpdateOrderAdapter implements UpdateOrderOutputPort {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public UpdateOrderAdapter(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderResponse updateOrder(Long id, OrderRequest updatedOrder) {

        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id.toString()));

        orderEntity.setCustomerName(updatedOrder.customerName());

        // Mapeia os itens existentes da ordem usando stream
        Map<Long, OrderItemEntity> existingItemsMap = orderEntity.getItems().stream()
                .collect(Collectors.toMap(orderItemEntity ->
                                orderItemEntity.getProduct().getId(),
                        orderItemEntity -> orderItemEntity));

        // Atualiza as quantidades dos itens existentes ou adiciona novos itens
        List<OrderItemEntity> updatedItems = updatedOrder.items().stream()
                .map(orderItem -> {
                    OrderItemEntity existingItem = existingItemsMap.get(orderItem.getProduct().getId());
                    if (existingItem != null) {
                        // Atualiza a quantidade do item existente
                        existingItem.setQuantity(orderItem.getQuantity());
                        return existingItem;
                    } else {
                        // Cria um novo item se não existir
                        ProductEntity productEntity = productRepository.findById(orderItem.getProduct().getId())
                                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + orderItem.getProduct().getId()));
                        return new OrderItemEntity(null, productEntity, orderItem.getQuantity(), orderEntity);
                    }
                })
                .collect(Collectors.toList());

                // Define os itens atualizados na ordem
                orderEntity.setItems(updatedItems);

                // Salva a ordem atualizada no banco de dados
                OrderEntity savedOrder = orderRepository.save(orderEntity);

                return new OrderResponse(savedOrder.getId(), savedOrder.getCustomerName(),
                        savedOrder.getItems().stream()
                                .map(orderItemEntity -> new OrderItemResponse(
                                        orderItemEntity.getId(),
                                        orderItemEntity.getProduct().getId(),
                                        orderItemEntity.getQuantity()))
                                .collect(Collectors.toList()));
    }
}

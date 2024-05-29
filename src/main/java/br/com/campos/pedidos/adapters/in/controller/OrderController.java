package br.com.campos.pedidos.adapters.in.controller;

import br.com.campos.pedidos.adapters.in.controller.request.OrderRequest;
import br.com.campos.pedidos.adapters.out.client.response.OrderResponse;
import br.com.campos.pedidos.application.core.usecase.order.CreateOrderUseCase;
import br.com.campos.pedidos.application.core.usecase.order.DeleteOrderUseCase;
import br.com.campos.pedidos.application.core.usecase.order.GetOrderUseCase;
import br.com.campos.pedidos.application.core.usecase.order.UpdateOrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private CreateOrderUseCase createOrderUseCase;
    private UpdateOrderUseCase updateOrderUseCase;
    private GetOrderUseCase getOrderUseCase;
    private DeleteOrderUseCase deleteOrderUseCase;

    @Autowired
    public OrderController(CreateOrderUseCase createOrderUseCase,
                           UpdateOrderUseCase updateOrderUseCase,
                           GetOrderUseCase getOrderUseCase,
                           DeleteOrderUseCase deleteOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.updateOrderUseCase = updateOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.deleteOrderUseCase = deleteOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest order) {
        OrderResponse createdOrder = createOrderUseCase.createOrder(order);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(createdOrder.getOrderId())
                        .toUri())
                .body(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable Long id,
                                                     @RequestBody OrderRequest order) {
        OrderResponse updatedOrder = updateOrderUseCase.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        Optional<OrderResponse> orderResponse = getOrderUseCase.getOrderById(id);
        return orderResponse.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> orders = getOrderUseCase.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        deleteOrderUseCase.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}

package br.com.campos.pedidos.adapters.out.order;

import br.com.campos.pedidos.adapters.out.repository.OrderRepository;
import br.com.campos.pedidos.application.ports.out.order.DeleteOrderOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteOrderAdapter implements DeleteOrderOutputPort {

    private OrderRepository orderRepository;

    public DeleteOrderAdapter(OrderRepository orderRepository) {
       this.orderRepository = orderRepository;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

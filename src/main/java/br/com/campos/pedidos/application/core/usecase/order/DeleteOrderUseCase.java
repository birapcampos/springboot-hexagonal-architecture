package br.com.campos.pedidos.application.core.usecase.order;

import br.com.campos.pedidos.application.ports.out.order.DeleteOrderOutputPort;

public class DeleteOrderUseCase {

    private DeleteOrderOutputPort deleteOrderOutputPort;

    public DeleteOrderUseCase(DeleteOrderOutputPort deleteOrderOutputPort) {
        this.deleteOrderOutputPort = deleteOrderOutputPort;
    }

    public void deleteOrder(Long id){
        deleteOrderOutputPort.deleteOrder(id);
    }

}

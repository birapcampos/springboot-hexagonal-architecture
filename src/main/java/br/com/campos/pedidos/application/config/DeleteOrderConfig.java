package br.com.campos.pedidos.application.config;

import br.com.campos.pedidos.application.core.usecase.order.DeleteOrderUseCase;
import br.com.campos.pedidos.application.ports.out.order.DeleteOrderOutputPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteOrderConfig {

    @Bean
    public DeleteOrderUseCase deleteOrderUseCase(
            DeleteOrderOutputPortImpl deleteOrderOutputPortImpl){
       return new DeleteOrderUseCase(deleteOrderOutputPortImpl);
    }

}

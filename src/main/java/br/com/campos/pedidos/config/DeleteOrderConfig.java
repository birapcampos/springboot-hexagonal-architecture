package br.com.campos.pedidos.config;

import br.com.campos.pedidos.application.core.usecase.order.DeleteOrderUseCase;
import br.com.campos.pedidos.adapters.out.order.implementation.DeleteOrderOutputPortImpl;
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

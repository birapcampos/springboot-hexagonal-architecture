package br.com.campos.pedidos.config;

import br.com.campos.pedidos.application.core.usecase.order.CreateOrderUseCase;
import br.com.campos.pedidos.adapters.out.order.implementation.CreateOrderOutputPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateOrderConfig {

    @Bean
    public CreateOrderUseCase createOrderUseCase(CreateOrderOutputPortImpl createOrderOutputPort){

        return new CreateOrderUseCase(createOrderOutputPort);
    }

}

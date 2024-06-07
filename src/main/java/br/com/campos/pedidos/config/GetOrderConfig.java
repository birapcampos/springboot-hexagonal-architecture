package br.com.campos.pedidos.config;

import br.com.campos.pedidos.application.core.usecase.order.GetOrderUseCase;
import br.com.campos.pedidos.adapters.out.order.implementation.GetOrderOutputPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetOrderConfig {
    @Bean
    public GetOrderUseCase getOrderUseCase(GetOrderOutputPortImpl getOrderOutputPort){
        return new GetOrderUseCase(getOrderOutputPort);
    }
}

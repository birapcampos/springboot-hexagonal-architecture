package br.com.campos.pedidos.config;

import br.com.campos.pedidos.adapters.out.order.GetOrderAdapter;
import br.com.campos.pedidos.application.core.usecase.order.GetOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetOrderConfig {
    @Bean
    public GetOrderUseCase getOrderUseCase(GetOrderAdapter getOrderOutputPort){
        return new GetOrderUseCase(getOrderOutputPort);
    }
}

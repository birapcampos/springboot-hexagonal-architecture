package br.com.campos.pedidos.config;

import br.com.campos.pedidos.adapters.out.mapper.OrderMapper;
import br.com.campos.pedidos.adapters.out.order.CreateOrderAdapter;
import br.com.campos.pedidos.application.core.usecase.order.CreateOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateOrderConfig {

    @Bean
    public CreateOrderUseCase createOrderUseCase(CreateOrderAdapter createOrderOutputPort,
                                                 OrderMapper orderMapper){

        return new CreateOrderUseCase(createOrderOutputPort,orderMapper);
    }

}

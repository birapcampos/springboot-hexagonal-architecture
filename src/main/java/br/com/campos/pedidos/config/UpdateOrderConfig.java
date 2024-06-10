package br.com.campos.pedidos.config;

import br.com.campos.pedidos.adapters.out.mapper.OrderMapper;
import br.com.campos.pedidos.adapters.out.order.UpdateOrderAdapter;
import br.com.campos.pedidos.application.core.usecase.order.UpdateOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderConfig {

    @Bean
    public UpdateOrderUseCase updateOrderUseCase(UpdateOrderAdapter updateOrderOutputPort,
                                                 OrderMapper orderMapper){
        return new UpdateOrderUseCase(updateOrderOutputPort,orderMapper);
    }

}

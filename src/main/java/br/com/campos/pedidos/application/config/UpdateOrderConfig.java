package br.com.campos.pedidos.application.config;

import br.com.campos.pedidos.application.core.usecase.order.UpdateOrderUseCase;
import br.com.campos.pedidos.application.ports.out.order.UpdateOrderOutputPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderConfig {

    @Bean
    public UpdateOrderUseCase updateOrderUseCase(UpdateOrderOutputPortImpl updateOrderOutputPort){
        return new UpdateOrderUseCase(updateOrderOutputPort);
    }

}

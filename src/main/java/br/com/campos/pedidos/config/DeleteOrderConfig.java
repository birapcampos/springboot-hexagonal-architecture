package br.com.campos.pedidos.config;

import br.com.campos.pedidos.adapters.out.order.DeleteOrderAdapter;
import br.com.campos.pedidos.application.core.usecase.order.DeleteOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteOrderConfig {

    @Bean
    public DeleteOrderUseCase deleteOrderUseCase(
            DeleteOrderAdapter deleteOrderOutputPortImpl){
       return new DeleteOrderUseCase(deleteOrderOutputPortImpl);
    }

}

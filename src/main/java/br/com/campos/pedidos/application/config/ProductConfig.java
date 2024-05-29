package br.com.campos.pedidos.application.config;

import br.com.campos.pedidos.application.core.usecase.product.ProductUseCase;
import br.com.campos.pedidos.application.ports.out.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductUseCase productUseCase(CreateProductOutputPortImpl createProductOutputPort,
                                         UpdateProductOutputPortImpl updateProductOutputPort,
                                         GetProductOutputPortImpl getProductOutputPort,
                                         DeleteProductOutputPortImpl deleteProductOutputPort){

        return new ProductUseCase(createProductOutputPort,
                updateProductOutputPort,
                getProductOutputPort,
                deleteProductOutputPort);
    }

}

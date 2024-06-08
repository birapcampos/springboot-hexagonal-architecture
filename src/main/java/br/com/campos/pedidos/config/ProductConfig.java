package br.com.campos.pedidos.config;

import br.com.campos.pedidos.application.core.usecase.product.Product;
import br.com.campos.pedidos.adapters.out.product.CreateProductAdapter;
import br.com.campos.pedidos.adapters.out.product.DeleteProductAdapter;
import br.com.campos.pedidos.adapters.out.product.GetProductAdapter;
import br.com.campos.pedidos.adapters.out.product.UpdateProductAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public Product productUseCase(CreateProductAdapter createProductOutputPort,
                                  UpdateProductAdapter updateProductOutputPort,
                                  GetProductAdapter getProductOutputPort,
                                  DeleteProductAdapter deleteProductOutputPort){

        return new Product(createProductOutputPort,
                updateProductOutputPort,
                getProductOutputPort,
                deleteProductOutputPort);
    }

}

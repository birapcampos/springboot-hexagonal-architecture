package br.com.campos.pedidos.adapters.out.product;

import br.com.campos.pedidos.adapters.out.mapper.ProductMapper;
import br.com.campos.pedidos.adapters.out.repository.ProductRepository;
import br.com.campos.pedidos.adapters.out.response.ProductResponse;
import br.com.campos.pedidos.application.core.domain.Product;
import br.com.campos.pedidos.application.ports.out.product.CreateProductOutputPort;
import org.springframework.stereotype.Component;

@Component
public class CreateProductAdapter implements CreateProductOutputPort {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public CreateProductAdapter(ProductRepository productRepository,
                                ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse create(Product product) {
        return productMapper.toProductResponse(productRepository.save(
                productMapper.toEntity(product)));
    }
}

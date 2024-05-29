package br.com.campos.pedidos.application.ports.out.product;

import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.adapters.out.repository.ProductRepository;
import br.com.campos.pedidos.adapters.out.client.mapper.ProductMapper;
import br.com.campos.pedidos.adapters.out.client.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductOutputPortImpl implements CreateProductOutputPort{

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public CreateProductOutputPortImpl(ProductRepository productRepository,
                                       ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse create(ProductRequest product) {
        return productMapper.toProductResponse(productRepository.save(productMapper.toEntity(product)));
    }
}

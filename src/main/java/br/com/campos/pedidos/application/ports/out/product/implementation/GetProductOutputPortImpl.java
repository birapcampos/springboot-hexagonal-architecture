package br.com.campos.pedidos.application.ports.out.product.implementation;

import br.com.campos.pedidos.adapters.out.repository.ProductRepository;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import br.com.campos.pedidos.application.exceptions.ProductNotFoundException;
import br.com.campos.pedidos.adapters.out.client.mapper.ProductMapper;
import br.com.campos.pedidos.adapters.out.client.response.ProductResponse;
import br.com.campos.pedidos.application.ports.out.product.GetProductOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class GetProductOutputPortImpl implements GetProductOutputPort {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    @Autowired
    public GetProductOutputPortImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<ProductResponse> getProduct(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (!productEntity.isPresent()) {
            throw new ProductNotFoundException(id.toString());
        }
        return productEntity.map(productMapper::toProductResponse);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}

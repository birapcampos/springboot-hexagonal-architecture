package br.com.campos.pedidos.adapters.out.product;

import br.com.campos.pedidos.adapters.out.repository.ProductRepository;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import br.com.campos.pedidos.exceptions.ProductNotFoundException;
import br.com.campos.pedidos.adapters.out.mapper.ProductMapper;
import br.com.campos.pedidos.adapters.out.response.ProductResponse;
import br.com.campos.pedidos.application.ports.out.product.GetProductOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class GetProductAdapter implements GetProductOutputPort {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    @Autowired
    public GetProductAdapter(ProductRepository productRepository, ProductMapper productMapper) {
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

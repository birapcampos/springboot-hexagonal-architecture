package br.com.campos.pedidos.application.ports.out.product;

import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.adapters.out.repository.ProductRepository;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import br.com.campos.pedidos.application.exceptions.ProductNotFoundException;
import br.com.campos.pedidos.adapters.out.client.mapper.ProductMapper;
import br.com.campos.pedidos.adapters.out.client.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UpdateProductOutputPortImpl implements UpdateProductOutputPort{

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    @Autowired
    public UpdateProductOutputPortImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest product) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if (productEntityOptional.isPresent()) {
            ProductEntity existingProductEntity = productEntityOptional.get();
            existingProductEntity.setName(product.getName());
            existingProductEntity.setPrice(product.getPrice());
            ProductEntity updatedProductEntity = productRepository.save(existingProductEntity);
            return productMapper.toProductResponse(updatedProductEntity);
        } else {
            throw new ProductNotFoundException(id.toString());
        }
    }
}

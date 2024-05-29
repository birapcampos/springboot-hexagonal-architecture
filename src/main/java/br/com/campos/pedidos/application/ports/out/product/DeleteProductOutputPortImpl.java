package br.com.campos.pedidos.application.ports.out.product;

import br.com.campos.pedidos.adapters.out.repository.ProductRepository;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import br.com.campos.pedidos.application.exceptions.ProductNotFoundException;
import br.com.campos.pedidos.adapters.out.client.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class DeleteProductOutputPortImpl implements DeleteProductOutputPort {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public DeleteProductOutputPortImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public void deleteProduct(Long id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if (!productEntityOptional.isPresent()) {
            throw new ProductNotFoundException(id.toString());
        }
        productRepository.deleteById(id);
    }

}

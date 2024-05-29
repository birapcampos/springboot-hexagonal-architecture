package br.com.campos.pedidos.adapters.out.client.mapper;

import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import br.com.campos.pedidos.application.core.domain.Product;
import br.com.campos.pedidos.adapters.out.client.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ProductMapper {

    public ProductResponse toProductResponse(ProductEntity entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice());
    }

    public ProductEntity toEntity(ProductRequest product){
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getPrice());
    }

}

package br.com.campos.pedidos.adapters.out.client.mapper;

import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.adapters.out.client.response.ProductResponse;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import org.springframework.stereotype.Component;
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
                product.id(),
                product.name(),
                product.price());
    }

}

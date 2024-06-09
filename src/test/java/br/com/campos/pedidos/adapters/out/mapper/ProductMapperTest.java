package br.com.campos.pedidos.adapters.out.mapper;

import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.adapters.out.response.ProductResponse;
import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    private final ProductMapper productMapper = new ProductMapper();

    @Test
    void testToProductResponse() {
        ProductEntity entity = new ProductEntity(1L, "Geladeira", 1500);
        ProductResponse response = productMapper.toProductResponse(entity);

        assertEquals(entity.getId(), response.getId());
        assertEquals(entity.getName(), response.getName());
        assertEquals(entity.getPrice(), response.getPrice());
    }

    @Test
    void testToEntity() {
        ProductRequest request = new ProductRequest(1L, "Geladeira", 1500);
        ProductEntity entity = productMapper.toEntity(request);

        assertEquals(request.id(), entity.getId());
        assertEquals(request.name(), entity.getName());
        assertEquals(request.price(), entity.getPrice());
    }
}

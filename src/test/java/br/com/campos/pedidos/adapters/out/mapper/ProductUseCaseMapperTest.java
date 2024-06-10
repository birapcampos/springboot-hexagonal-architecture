package br.com.campos.pedidos.adapters.out.mapper;

import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import br.com.campos.pedidos.adapters.out.response.ProductResponse;
import br.com.campos.pedidos.application.core.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductUseCaseMapperTest {

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
        Product request = new Product("Geladeira", 1500);
        ProductEntity entity = productMapper.toEntity(request);

        assertEquals(request.getId(), entity.getId());
        assertEquals(request.getName(), entity.getName());
        assertEquals(request.getPrice(), entity.getPrice());
    }
}

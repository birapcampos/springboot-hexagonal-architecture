package br.com.campos.pedidos.application.ports.in.product;

import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.adapters.out.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductInputPort {
    ProductResponse create(ProductRequest product);
    Optional<ProductResponse> getProduct(Long id);
    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(Long id, ProductRequest product);

    void deleteProduct(Long id);
}

package br.com.campos.pedidos.application.ports.out.product;

import br.com.campos.pedidos.adapters.out.client.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface GetProductOutputPort {

    Optional<ProductResponse> getProduct(Long id);
    List<ProductResponse> getAllProducts();
}

package br.com.campos.pedidos.application.ports.out.product;

import br.com.campos.pedidos.adapters.out.response.ProductResponse;
import br.com.campos.pedidos.application.core.domain.Product;

public interface UpdateProductOutputPort {
    ProductResponse updateProduct(Long id, Product product);
}

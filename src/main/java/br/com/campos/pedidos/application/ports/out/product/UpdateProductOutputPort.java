package br.com.campos.pedidos.application.ports.out.product;
import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.adapters.out.response.ProductResponse;

public interface UpdateProductOutputPort {
    ProductResponse updateProduct(Long id, ProductRequest product);
}

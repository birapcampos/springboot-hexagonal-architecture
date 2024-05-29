package br.com.campos.pedidos.application.ports.out.product;

import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.adapters.out.client.response.ProductResponse;

public interface CreateProductOutputPort {
    ProductResponse create(ProductRequest product);
}

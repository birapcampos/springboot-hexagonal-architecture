package br.com.campos.pedidos.application.core.usecase.product;

import br.com.campos.pedidos.adapters.in.controller.request.ProductRequest;
import br.com.campos.pedidos.application.ports.out.product.CreateProductOutputPort;
import br.com.campos.pedidos.application.ports.out.product.DeleteProductOutputPort;
import br.com.campos.pedidos.application.ports.out.product.GetProductOutputPort;
import br.com.campos.pedidos.application.ports.out.product.UpdateProductOutputPort;
import br.com.campos.pedidos.adapters.out.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public class ProductUseCase {

    private CreateProductOutputPort createProductOutputPort;
    private UpdateProductOutputPort updateProductOutputPort;

    private GetProductOutputPort getProductOutputPort;

    private DeleteProductOutputPort deleteProductOutputPort;

    public ProductUseCase(CreateProductOutputPort createProductOutputPort,
                          UpdateProductOutputPort updateProductOutputPort,
                          GetProductOutputPort getProductOutputPort,
                          DeleteProductOutputPort deleteProductOutputPort) {

        this.createProductOutputPort = createProductOutputPort;
        this.updateProductOutputPort = updateProductOutputPort;
        this.getProductOutputPort = getProductOutputPort;
        this.deleteProductOutputPort = deleteProductOutputPort;
    }


    public ProductResponse create(ProductRequest product){

        return createProductOutputPort.create(product);
    }

    public Optional<ProductResponse> getProduct(Long id) {

        return getProductOutputPort.getProduct(id);
    }

    public List<ProductResponse> getAllProducts() {

        return getProductOutputPort.getAllProducts();
    }

    public ProductResponse updateProduct(Long id, ProductRequest product) {
        return updateProductOutputPort.updateProduct(id,product);
    }
    public void deleteProduct(Long id) {

        deleteProductOutputPort.deleteProduct(id);
    }

}

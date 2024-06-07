package br.com.campos.pedidos.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {

        super("Produto não encontrado com este Id: " + id);
    }
}

package br.com.campos.pedidos.adapters.out.client.response;

public class ProductResponse {

    private Long id;
    private String name;
    private double price;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

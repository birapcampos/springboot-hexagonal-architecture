package br.com.campos.pedidos.adapters.out.repository;

import br.com.campos.pedidos.adapters.out.repository.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findAll();
}

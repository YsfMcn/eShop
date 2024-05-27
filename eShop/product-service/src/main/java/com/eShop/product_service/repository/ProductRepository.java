package com.eShop.product_service.repository;

import com.eShop.product_service.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // TODO: necessary  ??
public interface ProductRepository {
    Optional<Product> findById(Integer id);

    List<Product> findAll();

    boolean update(Product product);

    Product save(Product product);

    boolean delete(Integer id);
}

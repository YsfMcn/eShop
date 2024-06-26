package com.eShop.product_service.service;

import com.eShop.product_service.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    /*
    * Returns the product with the specified id.
    *
    * @param id     The ID of the product to retrieve.
    * @return       The requested product if found.
    * */
    Optional<Product> findById(Integer id);

    /*
    * Returns all products in the database.
    *
    * @return       All products in the database.
    * */
    List<Product> findAll();

    /*
    * Updates the specified product, identified by its id.
    *
    * @param product        The product to update.
    * @return               True if update succeeded, otherwise false.
    * */
    boolean update(Product product);

    /*
    * Saves the specified product to the database.
    *
    * @param product        The product to save to the database.
    * @return               The saved product.
    * */
    Product save(Product product);

    /*
    * Deletes the product with the specified id.
    *
    * @param id     The id of the product to delete.
    * @return       True if the operation was successful.
    * */
    boolean delete(Integer id);
}

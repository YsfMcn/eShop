package com.eShop.product_service.service;

import com.eShop.product_service.model.Product;
import com.eShop.product_service.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class) // to allow SpringExtension class to receive JUnit lifecycle notifications and manage our application context
@SpringBootTest // to tell spring to scan our class path and construct an application context
class ProductServiceTest {

    /*
    * The service that we want to test.
    * */
    @Autowired
    private ProductService service;

    /*
    * A mock version of the ProductRepository for use in our tests.
    * */
    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("Test findById Success")
    void testFindByIdSuccess() {
        // Setup our mock
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        doReturn(Optional.of(mockProduct)).when(productRepository).findById(1);

        // Execute the service call
        Optional<Product> returnedProduct = service.findById(1);

        // Assert the response
        Assertions.assertTrue(returnedProduct.isPresent(), "Product was not found!");
        Assertions.assertSame(returnedProduct.get(), mockProduct, "Products should be the same!");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock
        doReturn(Optional.empty()).when(productRepository).findById(1);

        // Execute the service call
        Optional<Product> returnedProduct = service.findById(1);

        // Assert the response
        Assertions.assertFalse(returnedProduct.isPresent(), "Product was found, when it shouldn't be!");
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup out mock
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        Product mockProduct2 = new Product(2, "Product Name 2", 15, 3);
        doReturn(List.of(mockProduct, mockProduct2)).when(productRepository).findAll();

        // Execute the service call
        List<Product> returnedProducts = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, returnedProducts.size(), "findAll should return 2 products");
    }

    @Test
    @DisplayName("Test save product")
    void testSave() {
        // Setup our mock
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        doReturn(mockProduct).when(productRepository).save(any());

        // Execute the service call
        Product returnedProduct = service.save(mockProduct);

        // Assert the response
        Assertions.assertNotNull(returnedProduct, "The saved product should not be null!");
        Assertions.assertEquals(1, returnedProduct.getVersion().intValue(), "The version for a new product should be 1");
    }
}
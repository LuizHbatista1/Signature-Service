package com.api.system_transaction.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import com.api.system_transaction.DTOS.ProductDTO;
import com.api.system_transaction.common.ProductConstants;
import com.api.system_transaction.domain.product.Product;
import com.api.system_transaction.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(classes = ProductService.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;


    @Test
    public void createProduct_withValidData_ReturnsPlanet(){

        ProductDTO productDTO = ProductConstants.PRODUCT_DTO;
        Product product = new Product(productDTO);

        when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);

        Product sut = productService.createProduct(productDTO);
        assertThat(sut).isEqualTo(product);


    }

    @Test
    public void createProduct_withInvalidData_ThrowsException(){

        ProductDTO productDTO = ProductConstants.INVALID_PRODUCT;
        Product product = new Product(productDTO);

        when(productRepository.save(product)).thenThrow(RuntimeException.class);

        assertThatThrownBy(()->productService.createProduct(productDTO)).isInstanceOf(RuntimeException.class);


    }
}

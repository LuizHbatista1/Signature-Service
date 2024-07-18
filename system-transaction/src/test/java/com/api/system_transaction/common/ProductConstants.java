package com.api.system_transaction.common;

import com.api.system_transaction.DTOS.ProductDTO;
import com.api.system_transaction.domain.product.Product;

public class ProductConstants {

    public static final ProductDTO PRODUCT_DTO = new ProductDTO("TestProduct", "TestProduct" , 19.00);
    public static final Product PRODUCT = new Product(PRODUCT_DTO);
    public static final ProductDTO INVALID_PRODUCT = new ProductDTO("","",00.00);


}

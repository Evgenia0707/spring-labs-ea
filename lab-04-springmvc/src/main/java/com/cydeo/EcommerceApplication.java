package com.cydeo;

import com.cydeo.service.CartService;
import com.cydeo.service.ProductService;
import com.cydeo.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EcommerceApplication.class, args);

        ProductService productService = context.getBean(ProductService.class);
        productService.initialiseProductList();

//        System.out.println("ProductServiceImpl.PRODUCT_LIST.size() = " + ProductServiceImpl.PRODUCT_LIST.size());

        CartService cartService = context.getBean(CartService.class);
        cartService.initialiseCartList();

    }

}

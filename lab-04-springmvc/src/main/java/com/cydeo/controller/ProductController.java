package com.cydeo.controller;

import com.cydeo.model.Product;
import com.cydeo.service.ProductService;
import com.cydeo.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductController {

//constructor injection
   private final ProductService productService;//create variable
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("/search-product/{productName}")
    public String searchProduct(@PathVariable ("productName") String productName, Model model) {

        model.addAttribute("productList", productService.searchProduct(productName));
        //     <tr th:each="product : ${productList}">

        return "product/product-list";
    }

}
/*
product/product-list.html
   <tr th:each="product : ${productList}">
            <td th:text="${product.getId()}"></td>
            <td th:text="${product.getName()}"></td>
            <td th:text="${product.getPrice()}"></td>
            <td th:text="${product.getRemainingQuantity()}"></td>
 */
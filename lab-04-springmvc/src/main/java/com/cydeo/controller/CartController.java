package com.cydeo.controller;

import com.cydeo.service.CartService;
import com.cydeo.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {
    //constructor injection
    private final CartService cartService;// not CartServiceImpl - bec loosely coupled
    public CartController(CartService carService) {
        this.cartService = carService;
    }


    @RequestMapping("/cart-list")
    public String listCarts(Model model) {

        model.addAttribute("cartList", cartService.retrieveCartList());
        //        <tr th:each="cart: ${cartList}">
        return "cart/cart-list";
    }


    @RequestMapping("/cart-list/{cartId}")
    public String retrieveListOfCartItems(@PathVariable UUID cartId, Model model) {

        model.addAttribute("cartItemList", cartService.retrieveCartDetail(cartId));
        // <  tr th:each="cartItem: ${cartItemList}">

        return "cart/cart-detail";
    }


}
/*
cart/cart-list
<tr th:each="cart: ${cartList}">
            <td th:text="${cart.getId()}"></td>
            <td th:text="${cart.getCartTotalAmount()}"></td>
        </tr>
 */
/*
cart/cart-detail.html
 <tr th:each="cartItem: ${cartItemList}">
            <td th:text="${cartItem.getProduct().getName()}"></td>
            <td th:text="${cartItem.getProduct().getId()}"></td>
            <td th:text="${cartItem.getProduct().getPrice()}"></td>
            <td th:text="${cartItem.getQuantity()}"></td>
        </tr>
 */
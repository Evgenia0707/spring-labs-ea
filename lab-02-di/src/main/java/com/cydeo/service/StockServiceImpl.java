package com.cydeo.service;

import com.cydeo.model.Product;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StockServiceImpl implements StockService{
    @Override
    public boolean checkStockIsAvailable(Product product, int quantity) {
        return product.getRemainingQuantity() > quantity;
    }

}

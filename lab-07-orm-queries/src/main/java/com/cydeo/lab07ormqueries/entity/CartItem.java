package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItem extends BaseEntity {//because has field it is not ManyToMany

    private Integer quantity;

    @ManyToOne
    private Cart cart;//obj

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}

package com.cydeo.lab06orm.entity;

import com.cydeo.lab06orm.enums.CartState;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Balance extends BaseEntity{

    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

}

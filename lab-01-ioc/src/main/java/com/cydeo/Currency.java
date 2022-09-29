package com.cydeo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Currency {
    private String code;
    private String name;
//    public Currency(String code, String name) {
//        this.code = code;
//        this.name = name;
//    }

    public String getCode() {
        return code;
    }

//    public void initialize(){
//        System.out.println("Currency" + "code: "+ code + "name: " + name);
//    }
}

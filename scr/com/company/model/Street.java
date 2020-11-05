package com.company.model;

import com.company.model.RealEstate;

public class Street extends RealEstate {

    public Street(String name, int cost, int defRent){
        setName(name);
        setCost(cost);
        setRent(defRent);
    }
}

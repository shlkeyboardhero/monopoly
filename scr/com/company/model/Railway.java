package com.company.model;

import com.company.model.RealEstate;

public class Railway extends RealEstate {

    public Railway(String name, int cost, int defRent) {
        setName(name);
        setCost(cost);
        setRent(defRent);
    }
}

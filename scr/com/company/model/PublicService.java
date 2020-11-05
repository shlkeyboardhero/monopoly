package com.company.model;

import com.company.model.RealEstate;

public class PublicService extends RealEstate {

    public PublicService(String name, int cost) {
        setCost(cost);
        setName(name);
        setRent(1);
    }

}

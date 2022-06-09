package com.solvd.photostudio.patterns.abstractFactory;

public class LaptopFactory implements AbstractFactory<ILaptop> {

    @Override
    public ILaptop create(String laptopType) {
        if ("Lenovo". equalsIgnoreCase(laptopType)) {
            return new Lenovo();
        } else if ("Mac".equalsIgnoreCase(laptopType)) {
            return new Mac();
        }
        return null;
    }
}

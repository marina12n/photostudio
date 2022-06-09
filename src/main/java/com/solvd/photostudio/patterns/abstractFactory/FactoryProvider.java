package com.solvd.photostudio.patterns.abstractFactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){

        if("Laptop".equalsIgnoreCase(choice)){
            return new LaptopFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }

        return null;
    }
}

package com.solvd.photostudio.patterns.abstractFactory;

public class ColorFactory implements AbstractFactory<IColor> {

    @Override
    public IColor create(String colorType) {
        if ("Blue". equalsIgnoreCase(colorType)) {
            return new Blue();
        } else if ("Red".equalsIgnoreCase(colorType)) {
            return new Red();
        }
        return null;
    }
}
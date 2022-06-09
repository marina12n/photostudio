package com.solvd.photostudio.patterns;

import com.solvd.photostudio.patterns.factory.Factory;
import com.solvd.photostudio.patterns.factory.IFactory;

public class FactoryExecutor {
    public static void main(String[] args) {
        Factory factory = new Factory();
        IFactory nikon = factory.create("Nikon");
        IFactory canon = factory.create("Canon");
        IFactory sony = factory.create("Sony");
        nikon.makePhoto();
        canon.makePhoto();
    }
}

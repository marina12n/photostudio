package com.solvd.photostudio.patterns.abstractFactory;

public interface AbstractFactory<L> {
    L create(String abstractType);
}

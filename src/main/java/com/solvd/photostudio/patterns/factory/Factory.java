package com.solvd.photostudio.patterns.factory;

public class Factory {
    public IFactory create(String typeOfPhotocamera) {
        switch (typeOfPhotocamera) {
            case "Nikon": return new Nikon();
            case "Canon": return new Canon();
            default: return null;
        }
    }
}
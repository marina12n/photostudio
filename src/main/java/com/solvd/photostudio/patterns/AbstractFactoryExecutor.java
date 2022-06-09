package com.solvd.photostudio.patterns;
import com.solvd.photostudio.patterns.abstractFactory.AbstractFactory;
import com.solvd.photostudio.patterns.abstractFactory.FactoryProvider;
import com.solvd.photostudio.patterns.abstractFactory.IColor;
import com.solvd.photostudio.patterns.abstractFactory.ILaptop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractFactoryExecutor {
    private static final Logger LOGGER = LogManager.getLogger(AbstractFactoryExecutor.class);

    public static void main(String[] args) {
        AbstractFactory abstractFactory;

        //creating a blue mac laptop
        abstractFactory = FactoryProvider.getFactory("Laptop");
        ILaptop laptop =(ILaptop) abstractFactory.create("Mac");

        abstractFactory = FactoryProvider.getFactory("Color");
        IColor color =(IColor) abstractFactory.create("Blue");

        LOGGER.info("Laptop: " + laptop.getLaptop() + " (" + color.getColor() + " color) ");
        }
    }

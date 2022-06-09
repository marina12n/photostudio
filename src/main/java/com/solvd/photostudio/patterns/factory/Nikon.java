package com.solvd.photostudio.patterns.factory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Nikon extends IFactory {
    private static final Logger LOGGER = LogManager.getLogger(Nikon.class);
    @Override
    public void makePhoto() {
        LOGGER.info("Make photo by Nikon");
    }
}

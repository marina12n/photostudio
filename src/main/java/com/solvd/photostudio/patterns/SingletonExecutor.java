package com.solvd.photostudio.patterns;
import com.solvd.photostudio.patterns.singleton.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingletonExecutor {
    private static final Logger LOGGER = LogManager.getLogger(SingletonExecutor.class);
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Singleton.i = 3;
        LOGGER.info(Singleton.i);
    }
}

package com.solvd.photostudio.patterns.observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class PublicFigure implements ISubject{
    private static final Logger LOGGER = LogManager.getLogger(PublicFigure.class);
    protected List<IObserver> observers = new ArrayList<IObserver>();

    protected String name;

    protected String handle;

    public PublicFigure(String name, String handle) {
        super();
        this.name = name;
        this.handle = "#" + handle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandle() {
        return handle;
    }

    public void tweet(String tweet) {
        LOGGER.info("\nName: %s, Tweet: %s\n", name, tweet);
        notifySubscribers(tweet);
    }

    @Override
    public synchronized void addSubscriber(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public synchronized void removeSubscriber(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers(String tweet) {
        observers.forEach(observer -> observer.notification(handle, tweet));
    }
}
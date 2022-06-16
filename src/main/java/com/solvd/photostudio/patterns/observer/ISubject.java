package com.solvd.photostudio.patterns.observer;

public interface ISubject {
    public void addSubscriber(IObserver observer);

    public void removeSubscriber(IObserver observer);

    public void notifySubscribers(String tweet);
}

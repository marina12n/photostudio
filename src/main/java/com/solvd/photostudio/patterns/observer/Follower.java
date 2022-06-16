package com.solvd.photostudio.patterns.observer;

public class Follower implements IObserver{

    protected String name;

    public Follower(String name) {
        super();
        this.name = name;
    }


    @Override
    public void notification(String handle, String tweet) {
        System.out.printf("'%s' received notification from Handle: '%s', Tweet: '%s'\n", name, handle, tweet);
    }
}

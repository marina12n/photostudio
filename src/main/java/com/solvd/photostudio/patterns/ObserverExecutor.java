package com.solvd.photostudio.patterns;
import com.solvd.photostudio.patterns.observer.Follower;
import com.solvd.photostudio.patterns.observer.PublicFigure;

public class ObserverExecutor {

    public static void main(String args[]) {
        PublicFigure stefani = new PublicFigure("Stefani Lock", "stefani");
        PublicFigure stepan = new PublicFigure("Stepan Petrenko", "helen");
        Follower john = new Follower("John");
        Follower emma = new Follower("Emma");
        Follower racheal = new Follower("Racheal");
        Follower micheal = new Follower("Micheal");
        Follower kim = new Follower("Kim");
        stefani.addSubscriber(john);
        stefani.addSubscriber(emma);
        stefani.addSubscriber(racheal);
        stefani.addSubscriber(micheal);
        stefani.addSubscriber(kim);
        stepan.addSubscriber(john);
        stepan.addSubscriber(emma);
        stepan.addSubscriber(racheal);
        stepan.addSubscriber(micheal);
        stepan.addSubscriber(kim);
        stefani.tweet("Hello Friends!");
        stepan.tweet("Glory!");
        stefani.removeSubscriber(racheal);
        stefani.tweet("Stay Home!");
    }
}
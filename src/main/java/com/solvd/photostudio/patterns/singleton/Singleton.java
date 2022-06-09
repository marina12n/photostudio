package com.solvd.photostudio.patterns.singleton;

public class Singleton {
        public static int i = 0;
        static Singleton singleton = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return singleton;
        }
    }
package com.java_practice_code.interview.practice.singleton.singletonenum;

public class Singleton {

    private Singleton() {
    }

    static enum SingletonEnum {
        INSTANCE;
        private Singleton singleton;

        private SingletonEnum() {
            singleton = new Singleton();
        }

        public Singleton getInstance() {
            return singleton;
        }
    }

    public static Singleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}

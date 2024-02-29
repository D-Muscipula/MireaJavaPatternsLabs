package org.example.Labs.task5;

public class AnotherOneSingleton {
    private static final AnotherOneSingleton anotherOneSingleton = new AnotherOneSingleton();

    private AnotherOneSingleton() {
    }

    public static AnotherOneSingleton getAnotherOneSingletonInstance(){
        return anotherOneSingleton;
    }
}

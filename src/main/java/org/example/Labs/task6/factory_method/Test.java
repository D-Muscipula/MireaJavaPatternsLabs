package org.example.Labs.task6.factory_method;

public class Test {
    public static void main(String[] args) {
        ConcreteCreatorA concreteCreatorA = new ConcreteCreatorA();
        ConcreteCreatorB concreteCreatorB = new ConcreteCreatorB();
        concreteCreatorA.anOperation();
        concreteCreatorB.anOperation();
    }
}

package org.example.Labs.task6.abstract_factory;

public class ConcreteFactory implements AbstractFactory{
    @Override
    public AbstractProduct createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ConcreteProductB();
    }
}

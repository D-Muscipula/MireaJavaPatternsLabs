package org.example.Labs.task6.abstract_factory;

public class ConcreteProductB implements AbstractProduct{
    @Override
    public void print(AbstractProduct abstractProduct) {
        System.out.println("B " + this.getClass() + " && " + abstractProduct.getClass());
    }
}

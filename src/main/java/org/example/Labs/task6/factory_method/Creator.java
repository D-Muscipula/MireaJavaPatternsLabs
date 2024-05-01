package org.example.Labs.task6.factory_method;

public abstract class Creator {
    public abstract Product factoryMethod();
    public void anOperation() {
        System.out.println(this.factoryMethod().getClass());
    }
}

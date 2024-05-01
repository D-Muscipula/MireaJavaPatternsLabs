package org.example.Labs.task6.Prototype;

public class ConcretePrototype1 implements Prototype{
    private int state = 101;
    @Override
    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return prototype;
    }

    @Override
    public String toString() {
        return "ConcretePrototype1{" +
                "state=" + state +
                '}';
    }
}

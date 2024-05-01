package org.example.Labs.task6.Prototype;

public class ConcretePrototype2 implements Prototype {
    private int state = 102;
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
        return "ConcretePrototype2{" +
                "state=" + state +
                '}';
    }
}

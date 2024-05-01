package org.example.Labs.task8.strategy;

public class Test {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        Context context1 = new Context(new ConcreteStrategyB());

        context.execute(2,8);
        context1.execute(2, 8);
    }
}

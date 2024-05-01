package org.example.Labs.task8.strategy;

public class ConcreteStrategyB implements Strategy{
    @Override
    public void execute(int a, int b) {
        System.out.println("Среднее геометрическое " + (Math.sqrt(a*b)));
    }
}

package org.example.Labs.task8.strategy;

public class ConcreteStrategyA implements Strategy{
    @Override
    public void execute(int a, int b) {
        System.out.println("Среднее арифметическое " + (a + b) / 2);
    }
}

package org.example.Labs.task6.builder;

public class ConcreteBuilder implements Builder{
    private ProductA product;

    public ConcreteBuilder() {
        this.product = new ProductA();
    }

    @Override
    public void buildPart1() {
        product.setPartA(100);
    }

    @Override
    public void buildPart2() {
        product.setPartB(200);
    }
    public Product getResult() {
        buildPart1();
        buildPart2();
        return product;
    }
}

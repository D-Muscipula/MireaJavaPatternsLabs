package org.example.Labs.task6.abstract_factory;

public class Client {
    AbstractFactory concreteFactory;
    private final AbstractProduct productA;
    private final AbstractProduct productB;

    public Client(AbstractFactory concreteFactory) {
        this.concreteFactory = concreteFactory;
        productA = concreteFactory.createProductA();
        productB = concreteFactory.createProductB();
    }

    public void execute() {
        productA.print(productB);
    }

    public static void main(String[] args) {
        ConcreteFactory concreteFactory = new ConcreteFactory();
        Client client = new Client(concreteFactory);
        client.execute();

    }
}

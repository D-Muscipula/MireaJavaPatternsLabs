package org.example.Labs.task6.Prototype;

public class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public static void main(String[] args) {
        Client client = new Client(new ConcretePrototype1());
        System.out.println(client.prototype + " " + client.prototype.clone());
        System.out.println(client.prototype == client.prototype.clone());
        Client client1 = new Client(new ConcretePrototype2());
        System.out.println(client1.prototype + " " + client1.prototype.clone());
        System.out.println(client1.prototype == client1.prototype.clone());
    }
}

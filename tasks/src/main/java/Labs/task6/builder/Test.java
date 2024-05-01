package Labs.task6.builder;

public class Test {
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        System.out.println(director.construct());
    }
}

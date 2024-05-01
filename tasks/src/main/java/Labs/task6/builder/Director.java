package Labs.task6.builder;

public class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        return builder.getResult();
    }
}

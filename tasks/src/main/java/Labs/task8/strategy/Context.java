package Labs.task8.strategy;

public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(int a, int b) {
        strategy.execute(a, b);
    }
}

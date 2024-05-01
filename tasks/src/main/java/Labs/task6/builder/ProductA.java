package Labs.task6.builder;

public class ProductA implements Product{
    private int partA;
    private int partB;

    public void setPartA(int partA) {
        this.partA = partA;
    }

    public void setPartB(int partB) {
        this.partB = partB;
    }

    public int getPartA() {
        return partA;
    }

    public int getPartB() {
        return partB;
    }

    @Override
    public String toString() {
        return "ProductA{" +
                "partA=" + partA +
                ", partB=" + partB +
                '}';
    }
}

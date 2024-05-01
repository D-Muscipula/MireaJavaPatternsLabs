package Labs.task6.abstract_factory;

public class ConcreteProductA implements AbstractProduct{

    @Override
    public void print(AbstractProduct abstractProduct) {
        System.out.println("A " + this.getClass() + " && " + abstractProduct.getClass());
    }
}

package Labs.task5;

public class Test {
    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        System.out.println(singleton.getInstance() == singleton.getInstance());
        System.out.println(SingletonEnum.INSTANCE == SingletonEnum.INSTANCE);
        System.out.println(AnotherOneSingleton.getAnotherOneSingletonInstance() == AnotherOneSingleton.getAnotherOneSingletonInstance());
    }
}

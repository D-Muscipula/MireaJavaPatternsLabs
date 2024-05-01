package Labs.task10;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Programmer junior = (Junior) applicationContext.getBean("junior");
        Programmer middle = (Middle) applicationContext.getBean("middle");
        Programmer senior = (Senior) applicationContext.getBean("senior");
        junior.doCoding();
        middle.doCoding();
        senior.doCoding();
    }
}

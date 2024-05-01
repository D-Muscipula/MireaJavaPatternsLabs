package Labs.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Task1Test {
    private final Task task = new Task();
    @Test
    void notAPowOfTwo() {
        List<Integer> list = List.of(-2, -1, 0, 3,5,6,7,9,11,12,13,14,15,17,18,19,20);
        for (Integer number:list) {
            Assertions.assertFalse(task.test(number));
        }
    }
    @Test
    void powOfTwo() {
        List<Integer> list = List.of(1,2,4,8,16,32,64,128,256);
        for (Integer number:list) {
            Assertions.assertTrue(task.test(number));
        }
    }
}

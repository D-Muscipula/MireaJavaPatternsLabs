package org.example.Labs.task1;

import java.util.function.Predicate;

public class Task implements Predicate<Integer> {
    @Override
    public boolean test(Integer number) {
        if (number <= 0) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }

    public static void main(String[] args) {
        Task task = new Task();
        System.out.println(task.test(-2));
        System.out.println(task.test(0));
        System.out.println(task.test(1));
        System.out.println(task.test(2));
        System.out.println(task.test(3));
        System.out.println(task.test(4));
        System.out.println(task.test(8));
    }
}
//@Override
//public boolean test(Integer number) {
//    if (number < 1) {
//        return false;
//    } else {
//        while (number != 1) {
//            int remainder = number % 2;
//            if (remainder != 0) {
//                return false;
//            }
//            number /= 2;
//        }
//    }
//    return true;
//}
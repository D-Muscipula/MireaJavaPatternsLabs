package task13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentProperties implements CommandLineRunner {
        @Value("${student.name}")
        private String name;

        @Value("${student.last_name}")
        private String lastName;

        @Value("${student.group}")
        private String group;

        public void printStudentInfo() {
            System.out.println("Имя студента: " + name);
            System.out.println("Фамилия студента: " + lastName);
            System.out.println("Группа студента: " + group);
        }

    @Override
    public void run(String... args) {
        printStudentInfo();
    }
}

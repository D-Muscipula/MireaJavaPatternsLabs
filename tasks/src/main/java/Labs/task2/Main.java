package Labs.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Main {
    private static final List<String> FIRST_NAMES = List.of("Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia", "James", "Isabella", "Benjamin");
    private static final List<String> LAST_NAMES = List.of("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez");

    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String firstName = FIRST_NAMES.get(i);
            String lastName = LAST_NAMES.get(i);
            int age = abs(lastName.hashCode()%100);
            int weight = 60 + i;
            LocalDate birthDate = LocalDate.now().minusYears(age);
            Human human = new Human(age, firstName, lastName, birthDate, weight);
            humans.add(human);
            //System.out.println(human);
        }
        System.out.println();
        String string = humans.stream()
                .sorted((a, b) -> - a.firstName().compareTo(b.firstName()))
                .filter((a) -> a.age() > 20)
                .limit(3)
                .map(Human::getFirstName)
                .collect(Collectors.joining(" "));
        System.out.println(string);
    }

}

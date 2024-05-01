package Labs.task2;

import java.time.LocalDate;
import java.util.Objects;

public final class Human {
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age, String firstName, String
            lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int age() {
        return age;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    public int weight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Human) obj;
        return this.age == that.age &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.birthDate, that.birthDate) &&
                this.weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, firstName, lastName, birthDate, weight);
    }

    @Override
    public String toString() {
        return "Human[" +
                "age=" + age + ", " +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "birthDate=" + birthDate + ", " +
                "weight=" + weight + ']';
    }

    public int getAge() {
        return age;
    }

    public Human setAge(int age) {
        this.age = age;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Human setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Human setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Human setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Human setWeight(int weight) {
        this.weight = weight;
        return this;
    }
}

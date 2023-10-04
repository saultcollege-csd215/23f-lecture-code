package _03_staying_immutable.withMethods;

public record Person(String name, int age, String hairColor) {

    // With methods
    public Person withName(String name) {
        return new Person(name, age, hairColor);
    }

    public Person withAge(int age) {
        return new Person(name, age, hairColor);
    }

    public Person withHairColor(String hairColor) {
        return new Person(name, age, hairColor);
    }
}

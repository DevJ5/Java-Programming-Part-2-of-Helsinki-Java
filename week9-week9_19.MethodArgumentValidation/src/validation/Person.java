package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name == "" || name.length() > 40) {
            throw new IllegalArgumentException("Name cannot be null and has to be shorter than 40 characters.");
        }
        this.name = name;
        if(age < 0 || age > 120) {
            throw new IllegalArgumentException("Age has to be between 0 and 120 years.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

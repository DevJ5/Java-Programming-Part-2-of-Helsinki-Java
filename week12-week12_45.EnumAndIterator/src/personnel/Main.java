package personnel;

public class Main {

    public static void main(String[] args) {
        // write test code here
        Person arto = new Person("Arto", Education.D);
        Employees t = new Employees();
        t.add(arto);
        t.print(Education.D);
    }
}

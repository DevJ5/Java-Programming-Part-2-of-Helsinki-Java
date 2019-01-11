
public class Main {

    public static void addSuitcasesFullOfBricks(Container container) {
        int i = 0;

        while(i < 100) {
            Thing brick = new Thing("brick", i + 1);
            Suitcase suitcase = new Suitcase(101);
            suitcase.addThing(brick);
            container.addSuitcase(suitcase);
            i++;
        }

    }

    public static void main(String[] args) {
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

}

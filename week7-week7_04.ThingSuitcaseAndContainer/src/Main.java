
public class Main {

    public static void addSuitcasesFullOfBricks(Container container) {
        int i = 0;
        while (i < 100) {
            Suitcase suitcase = new Suitcase(100);
            suitcase.addThing(new Thing("brick", i + 1));
            container.addSuitcase(suitcase);
            i++;
        }
    }

    public static void main(String[] args) {
        Thing book = new Thing("Happiness in three steps", 2);
        Thing mobile = new Thing("Nokia 3210", 1);
        Thing brick = new Thing("Brick", 4);

        Suitcase suitcase = new Suitcase(5);
        System.out.println(suitcase);

        System.out.println(suitcase.heaviestThing());

        suitcase.addThing(book);
        System.out.println(suitcase);

        suitcase.addThing(mobile);
        System.out.println(suitcase);

        suitcase.addThing(brick);
        System.out.println(suitcase);
    }

}

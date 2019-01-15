public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(30);
        Box box2 = new Box(100);

        Book book1 = new Book("bert", "2 wolven", 5);
        Book book2 = new Book("kees", "Kerstmis", 5);

        box1.add(book1);

        System.out.println(box1);

        box2.add(box1);
        System.out.println(box2);

        box2.add(box2);
        System.out.println(box2);
    }
}

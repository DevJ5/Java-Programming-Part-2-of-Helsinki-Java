public class Book<T> implements Comparable {
    private String author;
    private String name;
    private int publishingYear;
    private T ID;

    public Book(String author, String name, int publishingYear, T ID) {
        this.author = author;
        this.name = name;
        this.publishingYear = publishingYear;
        this.ID = ID;
    }

    public T getID() {
        return ID;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

import java.util.Objects;

public class Book {
    private String name;
    private int publishingYear;

    public Book(String name, int year) {
        this.name = name;
        this.publishingYear = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishingYear == book.publishingYear &&
                name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, publishingYear);
    }
}
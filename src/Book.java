import java.util.Objects;

public class Book {
    public int bookID;
    public int bookValue;

    public Book(int ID, int value) {
        this.bookID = ID;
        this.bookValue = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID &&
                bookValue == book.bookValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, bookValue);
    }
}

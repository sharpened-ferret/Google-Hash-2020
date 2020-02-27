import java.util.Comparator;

public class BookValueComparison implements Comparator {
    public int compare(Object o1, Object o2) {
        Book b1 = (Book)o1;
        Book b2 = (Book)o2;

        if (b1.bookValue == b2.bookValue) {
            return 0;
        }
        else if (b1.bookValue > b2.bookValue) {
            return 1;
        }
        else {
            return -1;
        }
    }

}

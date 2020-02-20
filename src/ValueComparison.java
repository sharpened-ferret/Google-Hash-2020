import java.util.Comparator;

public class ValueComparison implements Comparator {
    public int compare(Object o1, Object o2) {
        Library l1 = (Library)o1;
        Library l2 = (Library)o2;

        if (l1.value == l2.value) {
            return 0;
        }
        else if (l1.value > l2.value) {
            return 1;
        }
        else {
            return -1;
        }
    }
}

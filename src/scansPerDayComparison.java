import java.util.Comparator;

public class scansPerDayComparison implements Comparator {
    public int compare(Object o1, Object o2) {
        Library l1 = (Library)o1;
        Library l2 = (Library)o2;

        if (l1.scansPerDay == l2.scansPerDay) {
            return 0;
        }
        else if (l1.scansPerDay > l2.scansPerDay) {
            return 1;
        }
        else {
            return -1;
        }
    }
}

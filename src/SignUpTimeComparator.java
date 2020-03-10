import java.util.Comparator;

/**
 * Implements comparing Library objects, based on their signUpTime values
 *
 * File Created: 20/02/2020
 *
 * @author Neil Woodhouse
 * @version 1.0
 * */

public class SignUpTimeComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Library l1 = (Library)o1;
        Library l2 = (Library)o2;

        if (l1.signupTime == l2.signupTime) {
            return 0;
        }
        else if (l1.signupTime > l2.signupTime) {
            return 1;
        }
        else {
            return -1;
        }
    }
}

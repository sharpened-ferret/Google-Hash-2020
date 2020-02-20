import java.util.ArrayList;

public class Library {

    public int numbOfBooks;
    public int signupTime;
    public int scansPerDay;
    public int[] bookIDs;
    public ArrayList<Integer> sentOrder = new ArrayList<>();

    public Library(int numberOfBooks, int signupTime, int scansPerDay, int[] booksIDs) {
        this.numbOfBooks = numberOfBooks;
        this.signupTime = signupTime;
        this.scansPerDay = scansPerDay;
        this.bookIDs = booksIDs;
    }

}

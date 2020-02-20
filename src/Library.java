import java.util.ArrayList;

public class Library {

    public int numbOfBooks;
    public int signupTime;
    public int scansPerDay;
    ArrayList<Integer> bookNumbers = new ArrayList<Integer>();

    public Library(int numberOfBooks, int signupTime, int scansPerDay, int bookID) {
        this.numbOfBooks = numberOfBooks;
        this.signupTime = signupTime;
        this.scansPerDay = scansPerDay;
        bookNumbers.add(bookID);
    }

}

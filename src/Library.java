import java.util.ArrayList;

public class Library {

    public int libraryID;
    public int numOfBooks;
    public int signupTime;
    public int scansPerDay;
    public ArrayList<Book> bookIDs;
    public double value;
    public ArrayList<Integer> sentOrder = new ArrayList<>();
    public double averageBookValue;

    public Library(int numberOfBooks, int signupTime, int scansPerDay, ArrayList<Book> booksIDs, int libraryID, double averageBookValue) {
        this.numOfBooks = numberOfBooks;
        this.signupTime = signupTime;
        this.scansPerDay = scansPerDay;
        this.bookIDs = booksIDs;
        this.libraryID = libraryID;
        this.averageBookValue = averageBookValue;
        this.value = calcValue();
    }

    public double calcValue() {
        return ((scansPerDay*averageBookValue)*numOfBooks / (double)signupTime);
    }

}

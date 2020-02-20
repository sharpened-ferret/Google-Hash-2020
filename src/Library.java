import java.util.ArrayList;

public class Library {

    public int libraryID;
    public int numOfBooks;
    public int signupTime;
    public int scansPerDay;
    public int[] bookIDs;
    public double value;
    public ArrayList<Integer> sentOrder = new ArrayList<>();

    public Library(int numberOfBooks, int signupTime, int scansPerDay, int[] booksIDs, int libraryID) {
        this.numOfBooks = numberOfBooks;
        this.signupTime = signupTime;
        this.scansPerDay = scansPerDay;
        this.bookIDs = booksIDs;
        this.libraryID = libraryID;
        this.value = calcValue();
    }

    public double calcValue() {
        return scansPerDay / signupTime;
    }

}

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.Math.pow;

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
        this.averageBookValue = (averageBookValue*numberOfBooks)/(numberOfBooks+signupTime);
        this.value = calcValue();
    }

    public double calcValue() {
        return (((pow(scansPerDay,0)*pow(averageBookValue,0))*pow(numOfBooks,1)) / (double)pow(signupTime,0));
        //return averageBookValue*scansPerDay;
    }

    public int scoreTotal(int numDays) {
        numDays -= signupTime;
        int totalScore = 0;
        try {
            for (int i = 0; i < numDays; i++) {
                totalScore+=bookIDs.get(i).bookValue;
            }
        } catch(IndexOutOfBoundsException e) {

        }
        return totalScore;
    }

    public void bookUpdate(ArrayList<Book> BooksSent) {
        //HashSet<Integer> tempSet = new HashSet<>();
        for (Book book : BooksSent) {
            bookIDs.remove(book);
            numOfBooks=bookIDs.size();
            //tempSet.add(book.bookID);
        }
//        for (Book book : bookIDs) {
//            if (tempSet.contains(book.bookID)) {
//                System.out.println("Duplicate Detected!");
//            }
//        }
//        if (numOfBooks!=bookIDs.size()) {
//            System.out.println("Removed Duplicate(s)");
//            numOfBooks=bookIDs.size();
//        }
    }

}

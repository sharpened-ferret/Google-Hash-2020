import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //File Address loaded from arguments
        String fileAddress = args[0];

        //Local vars for data store [as required]
        int numBooks=0;
        int numLibraries=0;
        int numDays=0;

        //HashMap to reference data objects [replace object ref with real data object class name]
        HashMap<Integer, Integer> books = new HashMap<Integer, Integer>();
        HashMap<Integer, Library> libraries = new HashMap<Integer, Library>();

        //Increment to count line no.
        int increment=0;
        int libraryNum = 0;

        try{
            File input = new File(fileAddress);
            Scanner InputReader = new Scanner(input);
            while (InputReader.hasNextLine()) {
                String data = InputReader.nextLine();

                //Handles First Line differently to write initial settings to local vars (if required)
                if (increment==0) {
                    String[] lineArray = data.split(" ");
                    numBooks=Integer.parseInt(lineArray[0]);
                    numLibraries=Integer.parseInt(lineArray[1]);
                    numDays=Integer.parseInt(lineArray[2]);
                    increment++;
                }

                //Writes data to object [replace with real data object]
                else if(increment == 1) {
                    String[] lineArray =data.split(" ");
                    int bookIncrement = 0;
                    while (bookIncrement<lineArray.length) {
                        books.put(bookIncrement, Integer.parseInt(lineArray[bookIncrement]));
                        bookIncrement++;
                    }
                    increment++;
                }

                else {
                    String[] lineOneArray = data.split(" ");
                    int numBooksInLibrary = Integer.parseInt(lineOneArray[0]);
                    int signUpTime = Integer.parseInt(lineOneArray[1]);
                    int scansPerDay = Integer.parseInt(lineOneArray[2]);
                    String dataTwo = InputReader.nextLine();
                    String[] lineTwoArray = dataTwo.split(" ");
                    int[] bookIDs= new int[numBooksInLibrary];
                    for (int i=0; i<numBooksInLibrary; i++) {
                        bookIDs[i] = Integer.parseInt(lineTwoArray[i]);
                    }

                    libraries.put(libraryNum, new Library(numBooksInLibrary, signUpTime, scansPerDay, bookIDs));
                    libraryNum++;

                }
            }
            InputReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;

public class Main {

    //Local vars for data store [as required]
    static int numBooksA=0;
    static int numLibrariesA=0;
    static int numDaysA=0;
    static int numBooksB=0;
    static int numLibrariesB=0;
    static int numDaysB=0;
    static int numBooksC=0;
    static int numLibrariesC=0;
    static int numDaysC=0;
    static int numBooksD=0;
    static int numLibrariesD=0;
    static int numDaysD=0;
    static int numBooksE=0;
    static int numLibrariesE=0;
    static int numDaysE=0;
    static int numBooksF=0;
    static int numLibrariesF=0;
    static int numDaysF=0;

    public static void main(String[] args) {

        //HashMap to reference data objects [replace object ref with real data object class name]
        HashMap<Integer, Integer> booksA = new HashMap<Integer, Integer>();
        HashMap<Integer, Library> librariesA = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedA = new ArrayList<>();
        HashSet<Integer> bookSentA = new HashSet<Integer>();
        HashMap<Integer, Integer> booksB = new HashMap<Integer, Integer>();
        HashMap<Integer, Library> librariesB = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedB = new ArrayList<>();
        HashSet<Integer> bookSentB = new HashSet<Integer>();
        HashMap<Integer, Integer> booksC = new HashMap<Integer, Integer>();
        HashMap<Integer, Library> librariesC = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedC = new ArrayList<>();
        HashSet<Integer> bookSentC = new HashSet<Integer>();
        HashMap<Integer, Integer> booksD = new HashMap<Integer, Integer>();
        HashMap<Integer, Library> librariesD = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedD = new ArrayList<>();
        HashSet<Integer> bookSentD = new HashSet<Integer>();
        HashMap<Integer, Integer> booksE = new HashMap<Integer, Integer>();
        HashMap<Integer, Library> librariesE = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedE = new ArrayList<>();
        HashSet<Integer> bookSentE = new HashSet<Integer>();
        HashMap<Integer, Integer> booksF = new HashMap<Integer, Integer>();
        HashMap<Integer, Library> librariesF = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedF = new ArrayList<>();
        HashSet<Integer> bookSentF = new HashSet<Integer>();

        readFile("a_example.txt",numLibrariesA, booksA, librariesA, librarySortedA);
        readFile("b_read_on.txt",numLibrariesB, booksB, librariesB, librarySortedB);
        readFile("c_incunabula.txt",numLibrariesC, booksC, librariesC, librarySortedC);
        readFile("d_tough_choices.txt",numLibrariesD, booksD, librariesD, librarySortedD);
        readFile("e_so_many_books.txt",numLibrariesE, booksE, librariesE, librarySortedE);
        readFile("f_libraries_of_the_world.txt",numLibrariesF, booksF, librariesF, librarySortedF);

        Collections.sort(librarySortedA, new ValueComparison());
        Collections.sort(librarySortedB, new ValueComparison());
        Collections.sort(librarySortedC, new ValueComparison());
        Collections.sort(librarySortedD, new ValueComparison());
        Collections.sort(librarySortedE, new ValueComparison());
        Collections.sort(librarySortedF, new ValueComparison());

        writeFile("a_example.txt", numLibrariesA, librariesA, bookSentA, librarySortedA);
        writeFile("b_read_on.txt", numLibrariesB, librariesB, bookSentB, librarySortedB);
        writeFile("c_incunabula.txt", numLibrariesC, librariesC, bookSentC, librarySortedC);
        writeFile("d_tough_choices.txt", numLibrariesD, librariesD, bookSentD, librarySortedD);
        writeFile("e_so_many_books.txt", numLibrariesE, librariesE, bookSentE, librarySortedE);
        writeFile("f_libraries_of_the_world.txt", numLibrariesF, librariesF, bookSentF, librarySortedF);

    }

    public static void readFile(String fileAddress, int numberLibraries, HashMap<Integer, Integer> books, HashMap<Integer, Library> libraries, ArrayList<Library> librarySorted) {
        int numBooks = 0;
        int numLibraries = 0;
        int numDays = 0;

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

                    libraries.put(libraryNum, new Library(numBooksInLibrary, signUpTime, scansPerDay, bookIDs, libraryNum));
                    librarySorted.add(libraryNum, new Library(numBooksInLibrary, signUpTime, scansPerDay, bookIDs, libraryNum));
                    libraryNum++;

                }
            }
            InputReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (fileAddress.equals("a_example.txt")) {
            numLibrariesA = numLibraries;
        } else if (fileAddress.equals("b_read_on.txt")) {
            numLibrariesB = numLibraries;
        } else if (fileAddress.equals("c_incunabula.txt")) {
            numLibrariesC = numLibraries;
        } else if (fileAddress.equals("d_tough_choices.txt")) {
            numLibrariesD = numLibraries;
        } else if (fileAddress.equals("e_so_many_books.txt")) {
            numLibrariesE = numLibraries;
        } else if (fileAddress.equals("f_libraries_of_the_world.txt")) {
            numLibrariesF = numLibraries;
        }

    }

    public static void writeFile(String fileAddress, int numLibraries, HashMap<Integer, Library> libraries, HashSet<Integer> bookSent, ArrayList<Library> librariesSorted) {
        try {
            String fileOutput = "solution_" + fileAddress.substring(0,1) + ".txt";
            File output = new File(fileOutput);
            PrintWriter OutWriter = new PrintWriter(output);
            int usedLibraries = 0;
            String outputString = "";

            for (int i = 0; i < numLibraries; i++) {
                int numBooksSent = 0;
                String outStr = "";
                for (int bookID : librariesSorted.get(i).bookIDs) {
                    if (!bookSent.contains(bookID)) {
                        outStr += bookID + " ";
                        bookSent.add(bookID);
                        numBooksSent++;
                    }
                }
                if(!(numBooksSent == 0)) {
                    outputString+=librariesSorted.get(i).libraryID + " " + numBooksSent+"\n"+outStr+"\n";
                    usedLibraries++;
                }
            }
            OutWriter.println(usedLibraries+"\n"+outputString);
            OutWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


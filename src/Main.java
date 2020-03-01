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
        HashMap<Integer, Book> booksA = new HashMap<Integer, Book>();
        HashMap<Integer, Library> librariesA = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedA = new ArrayList<>();
        HashSet<Integer> bookSentA = new HashSet<Integer>();
        HashSet<Integer> librariesUsedA = new HashSet<>();

        HashMap<Integer, Book> booksB = new HashMap<Integer, Book>();
        HashMap<Integer, Library> librariesB = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedB = new ArrayList<>();
        HashSet<Integer> bookSentB = new HashSet<Integer>();
        HashSet<Integer> librariesUsedB = new HashSet<>();

        HashMap<Integer, Book> booksC = new HashMap<Integer, Book>();
        HashMap<Integer, Library> librariesC = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedC = new ArrayList<>();
        HashSet<Integer> bookSentC = new HashSet<Integer>();
        HashMap<Integer, Book> booksD = new HashMap<Integer, Book>();
        HashMap<Integer, Library> librariesD = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedD = new ArrayList<>();
        HashSet<Integer> bookSentD = new HashSet<Integer>();
        HashSet<Integer> librariesUsedD = new HashSet<>();
        HashMap<Integer, Book> booksE = new HashMap<Integer, Book>();
        HashMap<Integer, Library> librariesE = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedE = new ArrayList<>();
        HashSet<Integer> bookSentE = new HashSet<Integer>();
        HashSet<Integer> librariesUsedE = new HashSet<>();

        HashMap<Integer, Book> booksF = new HashMap<Integer, Book>();
        HashMap<Integer, Library> librariesF = new HashMap<Integer, Library>();
        ArrayList<Library> librarySortedF = new ArrayList<>();
        HashSet<Integer> bookSentF = new HashSet<Integer>();

//        readFile("a_example.txt",numLibrariesA, booksA, librariesA, librarySortedA);
//        readFile("b_read_on.txt",numLibrariesB, booksB, librariesB, librarySortedB);
//        readFile("c_incunabula.txt",numLibrariesC, booksC, librariesC, librarySortedC);
        readFile("d_tough_choices.txt",numLibrariesD, booksD, librariesD, librarySortedD);
//        readFile("e_so_many_books.txt",numLibrariesE, booksE, librariesE, librarySortedE);
//        readFile("f_libraries_of_the_world.txt",numLibrariesF, booksF, librariesF, librarySortedF);

        Collections.sort(librarySortedA, new ValueComparison());
        Collections.sort(librarySortedB, new ValueComparison());
        Collections.sort(librarySortedC, new ValueComparison());
        Collections.sort(librarySortedD, new BookNumberComparison());
        Collections.sort(librarySortedE, new ValueComparison());
        Collections.sort(librarySortedF, new ValueComparison());

//        Collections.sort(librarySortedA, new scansPerDayComparison());
//        Collections.sort(librarySortedB, new scansPerDayComparison());
//        Collections.sort(librarySortedC, new scansPerDayComparison());
//        Collections.sort(librarySortedD, new scansPerDayComparison());
//        Collections.sort(librarySortedE, new scansPerDayComparison());
//        Collections.sort(librarySortedF, new scansPerDayComparison());


        //writeFile("a_example.txt", numLibrariesA, librariesA, bookSentA, librarySortedA);
//        writeFile("b_read_on.txt", numLibrariesB, librariesB, bookSentB, librarySortedB);
//        writeFile("c_incunabula.txt", numLibrariesC, librariesC, bookSentC, librarySortedC);
//        writeFile("d_tough_choices.txt", numLibrariesD, librariesD, bookSentD, librarySortedD);
        writeFileD("d_tough_choices.txt", numLibrariesD, librariesD, bookSentD, librarySortedD);
//        writeFile("e_so_many_books.txt", numLibrariesE, librariesE, bookSentE, librarySortedE);
//        writeFile("f_libraries_of_the_world.txt", numLibrariesF, librariesF, bookSentF, librarySortedF);

    }

    public static void readFile(String fileAddress, int numberLibraries, HashMap<Integer, Book> books, HashMap<Integer, Library> libraries, ArrayList<Library> librarySorted) {
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
                        //books.put(bookIncrement, Integer.parseInt(lineArray[bookIncrement]));
                        Book tempBook= new Book(bookIncrement, Integer.parseInt((lineArray[bookIncrement])));
                        books.put(bookIncrement, tempBook);
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
                    ArrayList<Book> bookList = new ArrayList<>();
                    int[] bookIDs= new int[numBooksInLibrary];
                    int totalValue = 0;
                    for (int i=0; i<numBooksInLibrary; i++) {
                        bookIDs[i] = Integer.parseInt(lineTwoArray[i]);
                        Book tempBook = books.get(Integer.parseInt(lineTwoArray[i]));
                        bookList.add(i, tempBook);
                        totalValue+=tempBook.bookValue;
                    }
                    double averageValue = totalValue / bookIDs.length;
//                    System.out.println("Total value: "+totalValue+" Num Books: "+bookIDs.length);
//                    System.out.println("Average value:"+averageValue);
                    Collections.sort(bookList, new BookValueComparison());
                    libraries.put(libraryNum, new Library(numBooksInLibrary, signUpTime, scansPerDay, bookList, libraryNum, averageValue));
                    librarySorted.add(libraryNum, new Library(numBooksInLibrary, signUpTime, scansPerDay, bookList, libraryNum, averageValue));
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
                //System.out.println(librariesSorted.get(i).value);
                for (Book bookID : librariesSorted.get(i).bookIDs) {
                    if (!bookSent.contains(bookID.bookID)) {
                        outStr += bookID.bookID + " ";
                        bookSent.add(bookID.bookID);
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


    public static void writeFileD(String fileAddress, int numLibraries, HashMap<Integer, Library> libraries, HashSet<Integer> bookSent, ArrayList<Library> librariesSorted) {
        try {
            String fileOutput = "solution_" + fileAddress.substring(0,1) + ".txt";
            File output = new File(fileOutput);
            PrintWriter OutWriter = new PrintWriter(output);
            int usedLibraries = 0;
            String outputString = "";
            boolean completed = false;



            while (!completed) {
                System.out.println("Current Library: "+ librariesSorted.get(0).libraryID+", Used Libraries: "+usedLibraries);
                ArrayList<Book> booksSent = new ArrayList<>();
                int numBooksSent = 0;
                String outStr = "";
                //System.out.println(librariesSorted.get(i).value);
                for (Book bookID : librariesSorted.get(0).bookIDs) {
                    if (!bookSent.contains(bookID.bookID)) {
                        outStr += bookID.bookID + " ";
                        bookSent.add(bookID.bookID);
                        booksSent.add(bookID);
                        numBooksSent++;
                    }
                }
                if(!(numBooksSent == 0)) {
                    outputString+=librariesSorted.get(0).libraryID + " " + numBooksSent+"\n"+outStr+"\n";
                    usedLibraries++;
                }
                librariesSorted.remove(0);
                for (Library library : librariesSorted) {
                    library.bookUpdate(booksSent);
                }
                if (librariesSorted.size()==0) {
                    completed=true;
                }
                else {
                    Collections.sort(librariesSorted, new BookNumberComparison());
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


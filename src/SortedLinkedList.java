import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.Scanner;

/*
 * Steps to create the SortedLinkedList
 * 1) use the constructor to create the sorted linked list
 * 2) call readCsv()
 * 3) call create CsvArray()
 * 4) intialize() which will create the linkedlist
 */

public class SortedLinkedList {
    public static String data;
    private NodeType head;
    private NodeType currentPos;
    private final Scanner stdIn;
    private String csvPath;
    private int csvCounter;
    
    //constructor for MinesweeperGame
    public SortedLinkedList(Scanner stdIn, String csvPath){
        this.stdIn = stdIn;
        this.csvPath = csvPath;
        //this.readCsvFile(csvPath);
        this.initalize(readCsvFile(csvPath); //pipes csvfile into initalize
    }

    /**
     * Creates csv array from csv path
     */
    public int[] createCsvArray(String csvPath) {
        int[] csvArray = new int[csvCounter];//fix array size - ASN
        try {
              File configFile = new File(csvPath);
              Scanner configScanner = new Scanner(configFile);

              while (configScanner.hasNextInt()) {
                  csvCounter ++;
              } // while
              while (configScanner.hasNextInt()) {
                  csvArray[csvCounter] = configScanner.nextInt();
                  csvCounter ++;
              } // while
        }  // try
        catch (FileNotFoundException e) {
            System.out.println("Try Block : FileNotFoundException : " + e.getMessage());
        } // catch     
        return csvArray;
    } // createCsvArray

    /**
     * sets nodes and stuff
     */
    private initalize(int [] inCsvArray) {

    } //initalize

    public SortedLinkedList() {
        //using the compareTo method(ItemType), we can sort our list using the Next(NodeType method) - ASN
    }
    
    public int getLength() {
        //use a loop and add up the number of time we can go Next? - ASN
        
    }
    
    public void insertItem(ItemType item) {
        //same method as creating the list, just reorganize the nodes to include new variable - ASN
    }
    
    public void deleteItem(ItemType item) {
        //see above - ASN
    }
    
    public int searchItem(ItemType item) {
        //using similar loop as getLength, we can use compareTo method to find our answer - ASN
    }
    
    public ItemType getNextItem() {
        // Next method and getValue method should work - ASN
    }
    
    public void resetList() {
        // Use empty text file?
    }
    
    public void mergeList() {
        //loop insertItem and we should be good - ASN
    }
    
    public void deleteAlternate() {
        //loop deleteItem and we should be good - ASN
    }
    
    public void Intersection() {
        //Looping a simlar pattern from searchItem and compareTo should be helpful - ASM
    }
}



import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
//import NodeType; 

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
    private int[] csvArray;
    
    //constructor for SortedLinkedList
    public SortedLinkedList(Scanner stdIn, String csvPath){
        this.stdIn = stdIn;
        this.csvPath = csvPath;
        this.initialize(createCsvArray(csvPath)); //pipes csvfile into initalize
    }//SortedLinkedList

    /**
     * Creates csv array from csv path
     */
    public int[] createCsvArray(String csvPath) {
        csvArray = new int[csvCounter];
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
        Arrays.sort(csvArray);
        removeDuplicates(csvArray);
        return csvArray;
    } // createCsvArray

    /**
     * sets nodes and stuff
     * @return 
     */
    private void initialize(int [] inCsvArray) {
        head = new NodeType(new ItemType(inCsvArray[0]));
        currentPos = head;
        for (int i = 1; i < inCsvArray.length; i++) {
            if (i == inCsvArray.length -1) {
                currentPos.next(null);
                return;
            } else {
                NodeType nextNode = new NodeType(new ItemType(inCsvArray[i]));
                currentPos.next(nextNode);
                currentPos = nextNode;
            } // else 
        } // for
    } //initalize

    public int getLength() {
        return csvArray.length;
    }//getLength
    
    /**
     * sets currentPosition to the next Node
     */
    public void next() {
        currentPos = currentPos.getNext();
    } // next

    
    public void insertItem(ItemType item) {
        private int[] newCsvArray = new int[csvArray.length +1];
        if(searchItem(item) == -1) {
            System.out.println("Sorry. You cannot insert the duplicate item");    
        }  
        else if (getLength() == 0) { // if length is zero
            NodeType newNode = new NodeType(item);
            head = newNode;
            currentPos = head;
            newCsvArray[0] = item.getValue();
        } else if(searchItem(item == 1) { // if first item in list
            NodeType newNode = new NodeType(item);
            newNode.next(head);
            head = newNode;
            newCsvArray[0] = item.getValue;
            for (int i = 0; i < getLength; i ++) {
                newCsvArray[i+1] = csvArray[i];
            }
        } else { // general case
            NodeType newNode = new NodeType(item);
            currentPos = head;
            for (int i = 0; i < getLength(); i ++) {
                if(currentPos.info.compareTo(item) == -1) {
                    this.next();
                    newCsvArray[i] = csvArray[i];
                } if(currentPos.info.compareTo(item) == 0) {
                    Nodetype nextItem = currentPos.getNext();
                    currentPos.next(newNode);
                    newNode.next(nextItem);
                    newCsvArray[i] = item.getValue;
                } else {
                    Nodetype nextItem = currentPos.getNext();
                    currentPos.next(newNode);
                    newNode.next(nextItem);
                    newCsvArray[i] = item.getValue;
                } // else
            }//for
            csvArray = newCsvArray;
        }// else
    }//insertItem
    
    public void deleteItem(ItemType item) {
        if(searchItem(item) == -1) { // nonexistent item
            System.out.println("Item not found");
        }  
        else if (getLength() == 0) { // empty list
            System.out.println("You cannot delete from an empty list");
        } else if (getLength() == 1) { // only item
            private int[] newCsvArray = new int[0];
            head == null;
            csvArray = newCsvArray;
        } else if (searchItem(item) == 1) {
            private int[] newCsvArray = new int[getLength() - 1];
            NodeType tempNode = head.getNext();
            head == tempNode;
            for (int i = 0; i < getLength; i ++) {
                if (i == 0) {
                    // do nothing
                } else { 
                    newCsvArray[i-1] = csvArray[i];
                } // else
            } // for
            csvArray = newCsvArray;
        } else { // general
            currentPos = head;
            int i = 0;
            while (next() ! = null) {
                private int[] newCsvArray = new int[getLength() - 1];
                if(currentpos.info.compareto(item) == 0) {
                    currentPos.next(this.next().next());
                } // if
                newCsvArray[i] = currentPos.item.getValue();
            } // while
            csvArray = newCsvArray;
        } // else
    }//deleteItem
    
    public int searchItem(ItemType item) {
        for (int i = 0; i < getLength; i ++) {
            if (item.getValue == csvArray[i]) {
                return i;
            } // if 
        } // for 
        return -1;
    }//searchItem
    
    public ItemType getNextItem() {
        next();
        if (currentPos == null) {
            System.out.println("The end of the list has been reached");
        return currentPos.item;
    }//getNextItem
    
    public void resetList() {
        // set currentPos to null, somehow
        currentPos = null;
    }//resetList
    
    public void mergeList() {
        //loop insertItem and we should be good - ASN
        //Or scan what is entered, put it into new array, combine it with csvArray, and re-initialize
        //Dont forget to add print statement
        Scanner scanLength = new Scanner(System.in);
        System.out.println("Enter the length of the new list: ");
        int listLength = scanLength.nextInt();
        Scanner scanNew = new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        String stringInput = scanNew.nextLine();
        System.out.println("The list 1: " + toString());
        String[] numbers = stringInput.split(" ");
        int[] newLineArray = new int[listLength];
        
        for (int i = 0; i < listLength; i++) {
            newLineArray[i] = Integer.parseInt(numbers[i]);
        }//for
        
        String newListPrint = "The list 2: ";
        
        for (int i = 0; i < listLength; i++) {
            newListPrint.equals(newListPrint + newLineArray[i] + " ");
        }
        
        System.out.println(newListPrint);
        
        int[] mergedArray = new int[listLength + getLength()];
        for(int i = 0; i < listLength; i++) {
            mergedArray[i] = newLineArray[i];
        }
        for(int i = 0; i < getLength(); i++) {
            mergedArray[i + listLength] = csvArray[i];
        }
        
        Arrays.sort(mergedArray);
        csvArray = removeDuplicates(mergedArray);
        initialize(csvArray);
        System.out.println("Merged list: " + toString());
    }//mergeList
    
    public int[] removeDuplicates(int[] arr) {
        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {                  
                    /*int shiftLeft = j;
                    for (int k = j+1; k < end; k++, shiftLeft++) {
                        arr[shiftLeft] = arr[k];
                    }*/
                    arr[j] = arr[end-1];
                    end--;
                    j--;
                }//if
            }//for
        }//for

        int[] whitelist = new int[end];
        /*for(int i = 0; i < end; i++){
            whitelist[i] = arr[i];
        }*/
        System.arraycopy(arr, 0, whitelist, 0, end);
        return whitelist;
    }//removeDuplicates
    
    public void deleteAlternate() {
        //loop deleteItem and we should be good - ASN
        resetList();
        for(int i = 0; i < getLength(); i = i + 2) {
            deleteItem(getNextItem());
        }
    }//deleteAlternate
    
    public void Intersection() {
        //Looping a similar pattern from searchItem and compareTo should be helpful - ASN
        Scanner scanLength = new Scanner(System.in);
        System.out.println("Enter the length of the new list: ");
        int listLength = scanLength.nextInt();
        Scanner scanNew = new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        String stringInput = scanNew.nextLine();
        System.out.println("The list 1: " + toString());
        String[] numbers = stringInput.split(" ");
        int[] newLineArray = new int[listLength];
        
        for (int i = 0; i < listLength; i++) {
            newLineArray[i] = Integer.parseInt(numbers[i]);
        }//for
        
        String newListPrint = "The list 2: ";
        
        for (int i = 0; i < listLength; i++) {
            newListPrint.equals(newListPrint + newLineArray[i] + " ");
        }
        
        System.out.println(newListPrint);
        
        int[] mergedArray = new int[listLength + getLength()];
        for(int i = 0; i < listLength; i++) {
            mergedArray[i] = newLineArray[i];
        }
        for(int i = 0; i < getLength(); i++) {
            mergedArray[i + listLength] = csvArray[i];
        }
        
        Arrays.sort(mergedArray);
        
        int[] intersected = new int[mergedArray.length];
        int interCount = 0;
        
        for (int i = 0; i < mergedArray.length; i++) {
            for (int j = i + 1 ; j < mergedArray.length; j++) {
                 if (mergedArray[i] == mergedArray[j]) {
                       intersected[interCount] = mergedArray[i];
                       interCount++;
                 }
            }
        }
        csvArray = intersected;
        initialize(csvArray);
        System.out.println("Intersection of lists: " + toString());
        
    }//Intersection
    
    public String toString() {
        String toString = "";
        for(int i = 0; i < getLength(); i++) {
            toString.equals(toString + csvArray[i] + " ");
        }//for
        return toString;
    }//toString
}


//SortedLinkedList.java
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
        String fileContent;
        int numOfRows = 0;
        // arraylist to store strings
            List<String> listOfStrings = new ArrayList<String>();
            
            try {
                  File configFile = new File(csvPath);
                  Scanner scannedFileContent = new Scanner(configFile);
                  
               // checking end of file
                  while (scannedFileContent.hasNext()) {
                 fileContent = scannedFileContent.next();
                 numOfRows ++; 
                      // adding each string to arraylist
                      listOfStrings.add(fileContent);
                  }
                  
                  csvArray = new int[listOfStrings.size()];
                  
                  for (int i = 0; i < csvArray.length; i++) {
                 csvArray[i] = Integer.parseInt(listOfStrings.get(i));
                  }
            }  // try
            catch (FileNotFoundException e) {
                System.out.println("Try Block : FileNotFoundException : " + e.getMessage());
            } // catch     
            Arrays.sort(csvArray);
            removeDuplicates(csvArray, csvArray.length);
            return csvArray;
        } // createCsvArray

    /**
     * sets nodes and stuff
     * @return 
     */
    private void initialize(int [] inCsvArray) {
        head = new NodeType(new ItemType(inCsvArray[0]));
        currentPos = head;
        
        for (int i = 1; i <= inCsvArray.length; i++) {
            if (i == inCsvArray.length) {
                currentPos.setNext(null);
                return;
            } else {
                NodeType nextNode = new NodeType(new ItemType(inCsvArray[i]));
                currentPos.setNext(nextNode);
                currentPos = nextNode;
            } // else 
        } // for
    } //initialize

    public int getLength() {
        return csvArray.length;
    }//getLength
    
    /**
     * sets currentPosition to the next Node
     */
    public void goNext() {
        currentPos = currentPos.getNext();
    } // next

    
    public void insertItem(ItemType item) {
        int index = 1;
        if (searchItem(item) != -1) {   //NAGIREDDI
                System.out.println("Sorry. You cannot insert the duplicate item");
                System.out.println("The list is: " + toString());
        } else {
            // find index for new node that needs to be added
            for (int i = 0; i < csvArray.length; i ++) {
                if(csvArray[i] < item.getValue()) {
                    index ++;
                }
            }
            // create a newNode for item we need to add  
                NodeType newNode = new NodeType(item);

                if (head == null) {  // If no head exists
                    head = newNode;
                } else {
                    if (index == 1) { // if new node should be the first one..head
                    newNode.setNext(head); // this will link new node as the first node to head
                            head = newNode;
                    } else { // if new node should be added to anywhere in the sorted list
                        NodeType current = head;
                        NodeType temp = null;
                    
                        while (current != null && current.info.getValue() < newNode.info.getValue()) {
                        temp = current;
                        current = current.getNext();
                        }
                        temp.setNext(newNode);
                        newNode.setNext(current);
                    }
                }
                // display the list after new node is added
                displayLinkedList();
        }
    }

    public void displayLinkedList() {
        String newString ="";
        if (head == null) {
            System.out.println("The list is empty.");
        }
        NodeType current = head;
        int counter = 0;
        while (current != null) {
            newString = newString + current.info.getValue() + " ";
            current = current.getNext();
            counter++;
        }
        
        int[] temp = new int[counter];
        current = head;
        
        for(int i = 0; i < counter; i++) {
            temp[i] = current.info.getValue();
            current = current.getNext();
        }
        
        csvArray = temp;
        
        System.out.println("New list: " + newString );
    }
    
    public void deleteItem(ItemType item) { 
        int index = searchItem(item);
        if(index == -1) { // nonexistent item
            System.out.println("Item not found");
        } 
        else {
            if (index == 0) { // if 0 index to be deleted, move the head to next position
                head = head.getNext();
            } 
            else {
               NodeType previous = head; // first position is assigned to previous
               int count = 1;
               while (count < index) {
                   //move one position right and assign it to previous variable
                   previous = previous.getNext();
                   count++;
               }
               NodeType current = previous.getNext();
               previous.setNext(current.getNext());
            }
        
        }
        displayLinkedList();
    }
    
    public int searchItem(ItemType item) {
        for (int i = 0; i < getLength(); i ++) {
            if (item.getValue() == csvArray[i]) {
                return i;
            } // if 
        } // for 
        return -1;
    }//searchItem
    
    public ItemType getNextItem() {
        goNext();
        if (currentPos == null) {
            System.out.println("The end of the list has been reached"); 
            resetList();
        }
        return currentPos.info;
    }//getNextItem
    
    public void resetList() {
        // set currentPos to null, somehow
        currentPos.setNext(head);;
        head = null;
        int [] temp = new int[0];
        csvArray = temp;
    }//resetList
    
    /**
     * This is O(n) = n
     */
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
        Arrays.sort(newLineArray);
        
        for (int i = 0; i < listLength; i++) {
            newListPrint = newListPrint + newLineArray[i] + " ";
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
        csvArray = removeDuplicates(mergedArray, mergedArray.length);
        initialize(csvArray);
        System.out.println("Merged list: " + toString());
    }//mergeList
    
    public int[] removeDuplicates(int[] arr, int n) {
        if (n == 0 || n == 1) {
            return arr;
        }
 
        // creating another array for only storing
        // the unique elements
        int[] temp = new int[n];
        int j = 0;
 
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
 
        temp[j++] = arr[n - 1];
 
        // Changing the original array
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
 
        int[] filler = new int[j];
        for(int i = 0; i < filler.length; i++) {
            filler[i] = arr[i]; 
        }
        
        return filler;  
        
    }//removeDuplicates
    
    /**
     * This is O(n) = n
     */
    public void deleteAlternate() {
        //loop deleteItem and we should be good - ASN
        //resetList();
        /*
        int temp []; 
        if (csvArray.length % 2 == 0) {
            temp = new int [getLength() /2];
        } else {
            temp = new int[getLength() + 1];
        } // else
        for(int i = 0; i < temp.length; i++) {
            temp[i] = csvArray[i+2];
        }
        System.out.println("New shit");
        for (int i : temp) {
            System.out.print(i + " ");
        } // for
        */
        currentPos = head;
        while (currentPos.getNext() != null) {
            goNext();
            deleteItem(currentPos.info);
            goNext();
        }
    }//deleteAlternate
    
    /**
     * Has a O(n)= n^2
     */
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
        Arrays.sort(newLineArray);
        
        for (int i = 0; i < listLength; i++) {
            newListPrint = newListPrint + newLineArray[i] + " ";
        }
        System.out.println(newListPrint);
        System.out.print("Intersection");
        for (int i = 0; i < csvArray.length; i ++) {
            for (int j = 0; j < newLineArray.length; j ++) {
                if (csvArray[i] == newLineArray[j]) {
                    System.out.print(newLineArray[j] + " ");
                } // if
            } // for
        } // for
        System.out.println("");
        
       /* 
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
        
        /*for (int i = 0; i < mergedArray.length; i++) {
            for (int j = 0; j < mergedArray.length; j++) {
                 if (mergedArray[i] == mergedArray[j]) {
                       intersected[interCount] = mergedArray[i];
                       interCount++;
                 }
            }
        }*/
        /*
        int[] interValue = new int[interCount];
        for(int i = 0; i < interCount; i++) {
            interValue[i] = mergedArray[i];
        }
        
        csvArray = interValue;
        initialize(csvArray);
        System.out.println("Intersection of lists: " + toString());
        */
        
    }//Intersection
    
    public String toString() {
        String toString = "";
        for(int i = 0; i < getLength(); i++) {
            toString = toString + csvArray[i] + " ";
        }//for
        return toString;
    }//toString
}


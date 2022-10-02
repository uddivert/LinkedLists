import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        String seedPath = args[0]; 
        Scanner stdIn = new Scanner(System.in);
        SortedLinkedList list = new SortedLinkedList(stdIn, seedPath);
        Scanner scan = new Scanner(System.in);
        String command = "";
        do {
            System.out.println("Enter a command: ");
            command = scan.nextLine();
            if(command.equals("i")) {
                Scanner insertion = new Scanner(System.in);
                System.out.println("Enter a number to insert: ");
                int insert = insertion.nextInt();
                System.out.println("Original list: " + list.toString());
                ItemType input = new ItemType(insert);
                list.insertItem(input);
                //System.out.println("New list: " + list.toString());
            }
            else if (command.equals("d")) {
                Scanner deletion = new Scanner(System.in);
                System.out.println("Enter a number to delete: ");
                int delete = deletion.nextInt();
                System.out.println("Original list: " + list.toString());
                ItemType input = new ItemType(delete);
                list.deleteItem(input);
                //System.out.println("New list: " + list.toString()); - Print only if item is present to be deleted
                //Also, add this line to the delete method, so it only prints if the above condition is fulfilled
            }
            else if (command.equals("s")) {
                Scanner searching = new Scanner(System.in);
                System.out.println("Enter a number to search: ");
                int search = searching.nextInt();
                System.out.println("Original list: " + list.toString());
                ItemType input = new ItemType(search);
                if(list.getLength() == 0){
                    System.out.println("The list is empty");
                }
                else if(list.searchItem(input) == -1) {
                    System.out.println("Item is not present in the list");
                }
                else {
                    System.out.println("The item is present at index " + (list.searchItem(input) + 1));
                }
            }
            else if (command.equals("n")) {
                System.out.println(list.getNextItem().getValue());
            }
            else if (command.equals("r")) {
                list.resetList();
                System.out.println("Iterator is reset");
            }
            else if (command.equals("a")) {
                System.out.println("Original list: " + list.toString());
                list.deleteAlternate();    
                System.out.println("Modified list: " + list.toString());
            }
            else if (command.equals("m")) {
                list.mergeList();
            }
            else if (command.equals("t")) {
                list.Intersection();
            }
            else if (command.equals("p")) {
                System.out.println("The list is: " + list.toString());
            }
            else if (command.equals("l")) {
                System.out.println("The length of the list is: " + list.getLength());    
            }
            else if (command.equals("q")) {
                System.out.println("Exiting the program...");
                System.exit(0);
            }
            else {
                System.out.println("Invalid command try again: ");
            }
        } while(!command.equals("q"));
        System.out.println("Exiting the program...");
        System.exit(0);
    }//main method
}//LinkedListDriver.java

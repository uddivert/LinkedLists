import java.util.Scanner;

public class LinkedListDriver {
    ItemType list = new SortedLinkedList();//figure this out

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a command: ");
        String command = scan.nextLine();
        
        if(command.equals('i')) {
            list.insertItem(item);
        }
        else if (command.equals('d')) {
            list.deleteItem(item);
        }
        else if (command.equals('s')) {
            list.searchItem(item);
        }
        else if (command.equals('n')) {
            list.getNextItem();
        }
        else if (command.equals('r')) {
            list.resetItem();
        }
        else if (command.equals('a')) {
            list.deleteAlternate();    
        }
        else if (command.equals('m')) {
            list.mergeList();
        }
        else if (command.equals('t')) {
            list.Intersection();
        }
        else if (command.equals('p')) {
            //search for 0 and get next til the end
        }
        else if (command.equals('l')) {
            list.getLength();    
        }
        else if (command.equals('q')) {
            System.exit(0);
        }

    }
}


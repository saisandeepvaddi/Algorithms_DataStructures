package LearnLinkedLists;

import java.util.Scanner;

/**
 * About the code :
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.append(in.next());
        }
        System.out.println("Printing List: ");
        linkedList.printList();
    }
}

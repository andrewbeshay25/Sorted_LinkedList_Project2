public class Main {

    public static void main(String[] args) {
        SortedList<Integer> sortedList = new SortedList<>();

        // Test 1: Inserting elements
        System.out.println("Test 1: Insert elements");
        sortedList.insert(5);
        sortedList.insert(3);
        sortedList.insert(7);
        sortedList.insert(2);
        sortedList.insert(6);
        sortedList.insert(4);
        sortedList.insert(1);

        System.out.println("List after insertion:");
        printList(sortedList);

        // Test 2: Searching for elements
        System.out.println("\nTest 2: Search elements");
        System.out.println("Search 4: " + sortedList.search(4)); // Expected: true
        System.out.println("Search 8: " + sortedList.search(8)); // Expected: false

        // Test 3: Retrieving elements by index
        System.out.println("\nTest 3: Retrieve elements by index");
        try {
            System.out.println("Element at index 0: " + sortedList.retrieve(0)); // Expected: 1
            System.out.println("Element at index 3: " + sortedList.retrieve(3)); // Expected: 4
            System.out.println("Element at index 6: " + sortedList.retrieve(6)); // Expected: 7
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index access");
        }

        // Test 4: Removing elements
        System.out.println("\nTest 4: Remove elements");
        System.out.println("Removing 5");
        sortedList.remove(5);
        printList(sortedList);

        System.out.println("Removing 1");
        sortedList.remove(1);
        printList(sortedList);

        System.out.println("Removing 7");
        sortedList.remove(7);
        printList(sortedList);

        // Test 5: Iterator functionality
        System.out.println("\nTest 5: Iterator functionality");
        System.out.println("Iterating through the list:");
        for (Integer element : sortedList) {
            System.out.println(element);
        }

        // Test 6: Edge case - Remove an element not in the list
        System.out.println("\nTest 6: Remove an element not in the list (e.g. 10)");
        sortedList.remove(10);
        printList(sortedList);

        // Test 7: Edge case - Retrieve an index out of bounds
        System.out.println("\nTest 7: Retrieve an index out of bounds");
        try {
            System.out.println("Element at index 10: " + sortedList.retrieve(10)); // Should throw exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        }
    }

    // Utility method to print the entire list
    public static void printList(SortedList<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

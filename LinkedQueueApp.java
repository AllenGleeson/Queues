package Queue;

public class LinkedQueueApp {
    // Data members
    private LinkedQueue<String> linkedQueue;

    // Constructor
    public LinkedQueueApp() {
        linkedQueue = new LinkedQueue<>();
    }

    public static void main(String[] args) {
        // Test cases
        String testString1 = "\\begin \\begin \\begin text \\end more \\end end \\end";
        String testString2 = "bob went to the \\begin \\begin shop \\end \\end and \\end \\end";
        String testString3 = "\\Letsbegin \\grabbegin a text \\end drink \\end";
        String testString4 = "\\begin text \\end";
        String testString5 = "\\begin one \\begin two \\end three \\end four \\end extra";
        String testString6 = "\\begin something \\begin inside text \\end";
        String testString7 = "\\end orphaned tag";
        String testString8 = "\\begin text \\Letsbegin fake \\end";
        String testString9 = "\\begin first \\end \\end";
        String testString10 = "\\begin \\begin \\begin \\begin \\begin very deep \\end \\end \\end \\end \\end";

        // Array of test cases
        String[] tests = { testString1, testString2, testString3, testString4, testString5,
                testString6, testString7, testString8, testString9, testString10 };
        
        // Creates a new LinkedQueueApp for each test case
        for (int i = 0; i < tests.length; i++) {
            LinkedQueueApp app = new LinkedQueueApp();
            // Load tags from the test string
            app.loadData(tests[i]);
            // Validate and print result
            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Valid: " + app.validate());
            System.out.println("Get Size:" + app.linkedQueue.getSize());
            System.out.println("To String:" + app.linkedQueue);
            System.out.println("Peek: " + app.linkedQueue.peek());
        }
    }

    // Load data in and split by spaces
    public void loadData(String text) {
        String[] tags = text.split("\\s+");
        // Goes through each tag
        for (String tag : tags) {
            // Checks if the tag is \begin or \end
            if (tag.equals("\\begin") || tag.equals("\\end")) {
                // Adds tag to the queue with enqueue
                linkedQueue.enqueue(tag);
            }
        }
    }

    // Validate tags
    public boolean validate() {
        // Sets a balance counter
        int balance = 0;
        // Goes through the queue until it's empty
        while (linkedQueue != null && linkedQueue.getSize() > 0) {
            // Dequeues the next tag
            String tag = linkedQueue.dequeue();
            // Increments balance for \begin and decrements for \end
            if (tag.equals("\\begin")) {
                balance++;
            } else if (tag.equals("\\end")) {
                balance--;
                // If balance goes negative, return false
                if (balance < 0) {
                    return false;
                }
            }
        }
        // If balance is zero, tags are balanced
        return balance == 0;
    }
}
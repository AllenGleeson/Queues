package Queue;

// LinkedQueue class implementing QueueInterface
public class LinkedQueue<T> implements QueueInterface<T> {
    // Data members
    private QNode<T> front;
    private QNode<T> back;
    private int size;

    // Constructor
    public LinkedQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }
    
    @Override
    public void enqueue(T item) {
        // Handles null item case
        QNode<T> newQNode = new QNode<>(item);
        if (back == null) {
            front = back = newQNode;
        } else {
            // Link new node at the end of the queue and update back
            back.next = newQNode;
            back = newQNode;
        }
        // Increment size
        size++;
    }

    @Override
    public T dequeue() {
        // Handles empty queue case
        if (front == null) {
            return null;
        }
        // Get the front item and update front
        T data = front.data;
        front = front.next;
        // If the queue is now empty, update back to null
        if (front == null) {
            back = null;
        }
        // Decrement size
        size--;
        return data;
    }

    @Override
    public T peek() {
        // Checks if the queue is empty and returns the front item
        return (front != null) ? front.data : null;
    }

    @Override
    public String toString() {
        // Create new string builder and go through the queue
        StringBuilder sb = new StringBuilder();
        QNode<T> current = front;
        sb.append("[");
        // Checks if current is null
        while (current != null) {
            // Appends data to the string builder
            sb.append(current.data);
            // Adds a comma if there's a next node
            if (current.next != null) sb.append(", ");
            // Moves to the next node
            current = current.next;
        }
        sb.append("]");
        // Returns the string
        return sb.toString();
    }

    // Getter for size
    public int getSize() {
        return size;
    }
}
package Queue;

// Generic node class for LinkedQueue
public class QNode<T> {
    // Data members
    T data;
    QNode<T> next;

    // Constructor
    public QNode(T data) {
        this.data = data;
        this.next = null;
    }
}
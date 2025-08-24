package Queue;

// Queue interface for queue operations
public interface QueueInterface<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    String toString();
}
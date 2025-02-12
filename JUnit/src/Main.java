public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("===========JUnit Assignment===========");
        System.out.println("==========Jay Suratwala-11103=========");
        System.out.println("Queue initialized. Is it empty? " + queue.Empty());

        // Enqueue operations
        queue.enq(10);
        queue.enq(25);
        queue.enq(105);
        queue.enq(20);
        System.out.println("Queue length after enqueuing 4 elements: " + queue.len());
        System.out.println("Is the queue empty? " + queue.Empty());

        // Dequeue operations
        System.out.println("Dequeued element: " + queue.deq());
        System.out.println("Dequeued element: " + queue.deq());
        System.out.println("Dequeued element: " + queue.deq());
        System.out.println("Dequeued element: " + queue.deq());
        System.out.println("Is the queue empty after dequeuing all elements? " + queue.Empty());

        // Test the len() method
        System.out.println("Current queue length: " + queue.len());
        queue.enq(5);
        queue.enq(4);
        System.out.println("Queue length after enqueuing 2 elements: " + queue.len());

        // Test the clear() method
        queue.clear();
        System.out.println("Queue length after clearing: " + queue.len());
        System.out.println("Is the queue empty after clearing? " + queue.Empty());

        // Test enqueuing null values
        queue.enq(null);
        System.out.println("Queue length after enqueuing a null value: " + queue.len());
        System.out.println("Checking front element (expecting null): " + queue.check());
        System.out.println("Dequeuing a null value: " + queue.deq());

        // Final check on queue status
        System.out.println("Queue length at the end: " + queue.len());
        System.out.println("Is the queue empty at the end? " + queue.Empty());
    }
}

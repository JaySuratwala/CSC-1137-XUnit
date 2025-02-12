import org.junit.jupiter.api.*;
import static org.junit.jupiter.api .Assertions.*;
import java.util.NoSuchElementException;
public class QueueTest {
    Queue queue;
    @BeforeEach
    void setUp(){
        queue = new Queue();
    }
    @AfterEach
    void breakDown() { queue = null;}
    @Test
    @DisplayName("Testing enqueueing without error,Failure and Faults" )
    void testEnQ(){
        queue.enq(10);
        queue.enq(25);
        queue.enq(105);
        queue.enq(20);
        assertEquals(4,queue.len());
        assertFalse(queue.Empty());
    }
    @Test
    @DisplayName("Testing dequeueing without error,Failure and Faults" )
    void testDeQ(){
        queue.enq(10);
        queue.enq(25);
        queue.enq(105);
        queue.enq(20);
        assertEquals(10,queue.deq());
        assertEquals(25,queue.deq());
        assertEquals(105,queue.deq());
        assertEquals(20,queue.deq());
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Testing size of queue without error,Failure and Faults" )
    void testL(){
        assertEquals(0,queue.len());
        queue.enq(5);
        queue.enq(4);
        queue.enq(3);
        assertEquals(3,queue.len());
        queue.deq();
        assertEquals(2,queue.len());
        queue.clear();
        assertEquals(0,queue.len());
    }
    @Test
    @DisplayName("Testing an empty queue with Empty() and without error,Failure and Faults" )
    void testEmpty(){
        assertTrue(queue.Empty());
        queue.enq(15);
        assertFalse(queue.Empty());
        queue.deq();
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Testing an empty queue with clear() and without error,Failure and Faults" )
    void testClear(){
        queue.enq(10);
        queue.enq(25);
        queue.enq(105);
        queue.enq(20);
        assertFalse(queue.Empty());
        queue.clear();
        assertEquals(0,queue.len());
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Enqueueing Null value to perform Failure" )
    void enqNullValue(){
        queue.enq(null);
        assertFalse(queue.Empty());
//        assertTrue(queue.Empty());// Failed test case cuz we are trying to push a null value
    }
    @Test
    @DisplayName("Testing the size of empty queue with clear() and without error,Failure and Faults" )
    public void sizeCheckAfterEmpty(){
        queue.enq(10);
        queue.enq(25);
        queue.enq(105);
        queue.enq(20);
//        queue.Empty(); this will just empty the queue and still the space created for 4 variables will still be there reserved
        queue.clear();
        assertEquals(0,queue.len());
    }
    @Test
    public void testCheckNull(){
        assertEquals(0,queue.len());
        queue.enq(null);
        assertNull(queue.check());
    }
    @Test
    public void checkEmptyOnEmptyQueue(){
        assertEquals(0,queue.len());
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Dequeueing null value form queue to perform Error" )
    public void deqNullItem(){
        queue.enq(null);
        assertNull(queue.deq());
    }
    @Test
    @DisplayName("Enqueueing a large number of elements to test capacity limits")
    void testEnqLarge() {
        for (int i = 0; i < 100000; i++) {
            queue.enq(i);
        }
        assertEquals(100000, queue.len());
        assertFalse(queue.Empty());
        queue.clear();
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Dequeueing from an empty queue to perform Error")
    void testDeqEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.deq(); // This should throw an error when dequeuing from an empty queue
        });
    }
    @Test
    @DisplayName("Null enqueue followed by valid operations to detect Failure")
    void testNullEnqWithValidOperations() {
        assertThrows(IllegalArgumentException.class, () -> {
            queue.enq(null); // This should fail due to the null check
        });
        queue.enq(1);
        queue.enq(2);
        assertEquals(1, queue.deq());
        assertEquals(1, queue.len());
    }
    @Test
    @DisplayName("Clear queue and perform operations to find Faults")
    void testClearAndOperate() {
        queue.enq(10);
        queue.enq(20);
        queue.clear(); // Clear the queue
        assertTrue(queue.Empty());
        assertThrows(NoSuchElementException.class, () -> {
            queue.deq(); // Attempting to dequeue after clearing should cause an error
        });
    }
    @Test
    @DisplayName("Checking the state after mixed enqueue and dequeue operations")
    void testMixedOperations() {
        queue.enq(5);
        queue.enq(10);
        queue.deq(); // Remove 5
        queue.enq(15);
        queue.deq(); // Remove 10
        queue.enq(20);
        assertEquals(15, queue.deq()); // Should dequeue 15
        assertEquals(20, queue.deq()); // Should dequeue 20
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Check consistency with alternate enqueue and dequeue")
    void testAlternateEnqDeq() {
        queue.enq(1);
        assertEquals(1, queue.deq());
        queue.enq(2);
        queue.enq(3);
        assertEquals(2, queue.deq());
        queue.enq(4);
        assertEquals(3, queue.deq());
        assertEquals(4, queue.deq());
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Testing duplicate values in the queue")
    void testDuplicateValues() {
        queue.enq(5);
        queue.enq(5);
        queue.enq(5);
        assertEquals(3, queue.len());
        assertEquals(5, queue.deq());
        assertEquals(5, queue.deq());
        assertEquals(5, queue.deq());
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Testing state after multiple clears")
    void testMultipleClears() {
        queue.enq(1);
        queue.enq(2);
        queue.clear(); // First clear
        assertTrue(queue.Empty());
        queue.clear(); // Second clear should not break anything
        assertEquals(0, queue.len());
    }
    @Test
    @DisplayName("Peeking from an empty queue")
    void testPeekEmptyQueue() {
        assertNull(queue.check());
        assertTrue(queue.Empty());
    }
    @Test
    @DisplayName("Mix of null and valid objects in queue")
    void testNullAndValidMix() {
        queue.enq(null);
        queue.enq(42);
        assertNull(queue.deq()); // Null value dequeued first
        assertEquals(42, queue.deq());
        assertTrue(queue.Empty());
    }
}
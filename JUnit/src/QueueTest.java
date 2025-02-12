import org.junit.jupiter.api.*;
import static org.junit.jupiter.api .Assertions.*;

public class QueueTest {
    Queue queue;
    @BeforeEach
    void setUp(){
        queue = new Queue();
    }
    @AfterEach
    void breakDown() { queue = null;}
    @Test
    void testEnQ(){
        queue.enq(10);
        queue.enq(25);
        queue.enq(105);
        queue.enq(20);
        assertEquals(4,queue.len());
        assertFalse(queue.Empty());
    }
    @Test
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
    void testEmpty(){
        assertTrue(queue.Empty());
        queue.enq(15);
        assertFalse(queue.Empty());
        queue.deq();
        assertTrue(queue.Empty());
    }
    @Test
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
    void enqNullValue(){
        queue.enq(null);
        assertFalse(queue.Empty());
//        assertTrue(queue.Empty());// Failed test case cuz we are trying to push a null value
    }
    @Test
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
    public void deqNullItem(){
        queue.enq(null);
        assertNull(queue.deq());
    }
}
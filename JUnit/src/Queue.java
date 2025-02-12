import java.util.LinkedList;
public class Queue {
    private LinkedList<Object> queue;
    public Queue(){
        this.queue = new LinkedList<>();
    }
    public void enq(Object v){
        if(v == null){throw new IllegalArgumentException("Variable (v) is null.");}
//        queue.addFirst(v); // Logical error
        queue.addLast(v);//Changed it from addFirst to addLast as it's a queue should be build on FIFO rule.
    }
    public Object deq(){
        if (queue.isEmpty()){return null;}
//        queue.removeLast(); // Logical error
        return queue.removeFirst(); //Changed it from removeLast to removeFirst as it's a queue should be build on FIFO rule.
    }
    public int len(){return queue.size();}
    public boolean Empty(){return queue.isEmpty();}
    public void clear(){
        queue.clear();
    }
    public Object check(){
        return queue.peekFirst();
    }
}
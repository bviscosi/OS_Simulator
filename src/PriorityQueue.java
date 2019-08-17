
public class PriorityQueue extends LinkedQueue<Process> {

    protected PriorityNode front;
    protected PriorityNode rear;
    protected int size;

    public PriorityQueue() {
        front = rear = new PriorityNode(null, 100, null);
        size = 0;
    }

    @Override
    public int length() {
        return size; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean enqueue(PriorityNode p) {
        PriorityNode temp = front.getNext();
        if (size == 0) {
            rear.setNext(p);
            rear = rear.getNext();
            size++;
            return true;
        } else if (size > 0) {

            while (p.getPriority() >= temp.getPriority() && temp != rear) {
                temp = temp.getNext();
            }

            p.setNext(temp.getNext());
            temp.setNext(p);
            size++;

        }
        return true;
    }

//        PriorityQueue tempQ = new PriorityQueue();
//        
//        
//        
//
//        if (size == 0) {
//            tempQ.rear.setNext(new PriorityNode(p.getData(), p.getPriority(), null));
//            tempQ.rear = tempQ.rear.getNext();
//            tempQ.size++;
//        } else {
//            while (p.getPriority() > tempQ.front.getPriority() && tempQ.front.getNext() != null) { // lower number = higher priority, checks if new node is less important than current front
//                int tempPriority = front.getPriority();
//                tempQ.rear.setNext(new PriorityNode(dequeue(), tempPriority, null));
//                tempQ.rear = tempQ.rear.getNext();
//                tempQ.size++;
//            }
//            tempQ.enqueue(p);
//
//            for (int i = 0; i < length(); i++) {
//                int tempPriority = front.getPriority();
//                tempQ.rear.setNext(new PriorityNode(dequeue(), tempPriority, null));
//                tempQ.rear = tempQ.rear.getNext();
//                tempQ.size++;
//            }
//
//            for (int i = 0; i < tempQ.length(); i++) {
//                int tempPriority = tempQ.front.getPriority();
//                enqueue(new PriorityNode(tempQ.dequeue(), tempPriority, null));
//            }
//        }
//        return true;
    @Override
    public Process dequeue() {

        {
            if (size == 0) {
                return null;
            }
            Process it = (Process) front.getNext().getData();
            front.setNext(front.getNext().getNext());
            if (front.getNext() == null) {
                rear = front;
            }
            size--;
            return it;
        } //To change body of generated methods, choose Tools | Templates.
    }
}

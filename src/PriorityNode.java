
public class PriorityNode<E> extends LinkedNode<E> {

    protected int priority;

    public PriorityNode(E data, int p, PriorityNode<E> next) {
        super(data, next);
        priority = p;
    }

    public void setNext(PriorityNode next) {
        super.setNext(next); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PriorityNode<E> getNext() {
        return (PriorityNode<E>) next;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}

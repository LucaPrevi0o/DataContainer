package DataContainer;

public class Vector<T> {

    private T value=null; //stored value
    private Vector<T> next=null; //next element in vector
    private Vector(T e) { this.value=e; } //initializer compiler

    public Vector<T> push(T e) {

        Vector<T> i;
        for (i=this; i.next!=null; i=i.next);
        i.next=new Vector<T>(e);
        return this;
    }

    public T get(int index) throws ArrayIndexOutOfBoundsException {

        Vector<T> i=this;
        for (int a=0; a<index && i!=null; a++) i=i.next;
        if (i==null) throw new ArrayIndexOutOfBoundsException();
        return i.value;
    }

    public Vector() {} //empty constructor
}
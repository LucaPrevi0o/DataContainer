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

    public Vector() {} //empty constructor
}
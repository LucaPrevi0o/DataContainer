package DataContainer;

public class Vector<T> {

    private T value=null; //stored value
    private Vector<T> next=null; //next element in vector
    private Vector(T e) { this.value=e; } //private initializer compiler

    public Vector<T> push(T e) { //add new element in last position

        Vector<T> i; //iterator element
        for (i=this; i.next!=null; i=i.next); //scroll the entire list
        i.next=new Vector<T>(e); //add new element as last
        return this; //return this (for chaining)
    }

    public T get(int index) throws ArrayIndexOutOfBoundsException { //return element in specified position (throws exception)

        Vector<T> i=this; //iterator element
        for (int a=0; a<index && i!=null; a++) i=i.next; //scroll the list until index or last element
        if (i==null) throw new ArrayIndexOutOfBoundsException(); //throw exception if null element
        return i.value; //return element in index position otherwise
    }

    public Vector() {} //empty constructor
}
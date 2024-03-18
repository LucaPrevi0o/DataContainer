package DataContainer;

public class Vector<T> {

    private T value=null; //stored value
    private Vector<T> next=null; //next element in vector
    private Vector(T e) { this.value=e; } //private initializer compiler

    public int size() { //return vector size

        int l=0; //vector size
        for (Vector<T> i=this.next; i!=null; i=i.next) l++; //update vector size
        return l; //return calculated size
    }

    public Vector<T> push(T e) { //add new element in last position

        Vector<T> i; //iterator element
        for (i=this; i.next!=null; i=i.next); //scroll the entire list
        i.next=new Vector<T>(e); //add new element as last
        return this; //return this (for chaining)
    }

    public Vector<T> set(int index, T e) { //update value in index specified position

        Vector<T> i=this.next; //iterator element from next element (this is just a root for the vector with null value)
        for (int a=0; a<index && i!=null; a++) i=i.next; //scroll the list until index or last element
        if (i==null) throw new ArrayIndexOutOfBoundsException(); //throw exception if null element
        i.value=e; //update value in index position
        return this; //return this (for chaining)
    }

    public Vector<T> add(int index, T e) { //add element in index specified position

        Vector<T> newE=new Vector<T>(e), prev=null, i=this.next; //iterator element from next element (this is just a root for the vector with null value)
        for (int a=0; a<index && i!=null; a++) { //scroll the list until index or last element
            
            prev=i; //save previous element
            i=i.next; //save element in index position
        }

        if (i==null) throw new ArrayIndexOutOfBoundsException(); //throw exception if null element
        newE.next=i; //put the element before the rest of the vector
        prev.next=newE; //add the element to the vector from previous index
        return this; //return this (for chaining)
    }

    public Vector<T> append(T e) { //add element in first position

        Vector<T> newE=new Vector<T>(e), thisE=this.next; //new element, reference to first element
        newE.next=thisE; //add new element in first position
        this.next=newE; //update vector after new element
        return this; //return this (for chaining)
    }

    public T get(int index) { //return element in specified position (throws exception)

        Vector<T> i=this.next; //iterator element from next element (this is just a root for the vector with null value)
        for (int a=0; a<index && i!=null; a++) i=i.next; //scroll the list until index or last element
        if (i==null) throw new ArrayIndexOutOfBoundsException(); //throw exception if null element
        return i.value; //return element in index position otherwise
    }

    public String toString() { //standard method: toString

        if (this.next==null) return "Vector<null>(0) {}"; //empty list header
        String res=""+this.getClass().getSimpleName()+"<"+this.next.value.getClass().getSimpleName()+">("+this.size()+") { "; //data type header
        for (int a=0; a<this.size(); a++) res+=(this.get(a).toString()+" "); //add elements of vector as string
        return res+"}"; //return vector as string
    }

    public boolean equals(Vector<T> other) { //standard method: equals

        if (this.size()!=other.size()) return false; //vectors are different if not of same size
        for (int a=0; a<this.size(); a++) if (!this.get(a).equals(other.get(a))) return false; //vectors are not equal if any element is different
        return true; //vectors are equal otherwise
    }

    public Vector<T> copy() { //create copy of this vector

        Vector<T> newV=new Vector<T>(); //create new vector
        for (int i=0; i<this.size(); i++) newV.push(this.get(i)); //push every element to the vector
        return newV; //return copy of this vector
    }

    public Vector() {} //empty constructor

    public Vector(Vector<T> e) { for (int i=0; i<e.size(); i++) this.push(e.get(i)); } //copy constructor
}
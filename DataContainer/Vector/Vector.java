package DataContainer.Vector;

import java.util.Iterator;
import DataContainer.Exception.*;

public class Vector<T> implements Iterable<T> {

    protected T value=null; //stored value
    protected Vector<T> next=null; //next element in vector
    private Vector(T value) { this.value=value; } //private initializer compiler
    public Vector(T... list) { for (var a: list) this.push(a); }
    public Vector() {}

    public int size() { //return vector size

        int l=0; //vector size
        for (var i=this; i.next!=null; i=i.next) l++; //update vector size
        return l; //return calculated size
    }

    public Vector<T> push(T value) { //add new element in last position

        var i=this; //iterator element
        while (i.next!=null) i=i.next; //scroll the entire list
        i.next=new Vector<T>(value); //add new element as last
        return this; //return this (for chaining)
    }

    public Vector<T> add(int index, T value) { //add element in index specified position

        try {

            if (index<0) throw new VectorOutOfBoundsException("Index "+index+" is negative"); //throw exception if negative index
            if (index>=this.size()) throw new VectorOutOfBoundsException("Index "+index+" is greater than last index "+(this.size()-1)); //throw exception if index is larger than Vector size
            Vector<T> newE=new Vector<T>(value), prev=null, i=this.next; //iterator element from next element (this is just a root for the vector with null value)
            for (var a=0; a<index; a++) { //scroll the list until index or last element
                
                prev=i; //save previous element
                i=i.next; //save element in index position
            }
    
            newE.next=i; //put the element before the rest of the vector
            prev.next=newE; //add the element to the vector from previous index
            return this; //return this (for chaining)
        } catch (Exception e) {

            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public Vector<T> append(T value) { //add element in first position

        Vector<T> newE=new Vector<T>(value), thisE=this.next; //new element, reference to first element
        newE.next=thisE; //add new element in first position
        this.next=newE; //update vector after new element
        return this; //return this (for chaining)
    }

    public Vector<T> set(int index, T value) { //update value in index specified position

        try {

            if (index<0) throw new VectorOutOfBoundsException("Index "+index+" is negative"); //throw exception if negative index
            if (index>=this.size()) throw new VectorOutOfBoundsException("Index "+index+" is greater than last index "+(this.size()-1)); //throw exception if index is larger than Vector size
            var i=this.next; //iterator element from next element (this is just a root for the vector with null value)
            for (int a=0; a<index; a++) i=i.next; //scroll the list until index
            i.value=value; //update value in index position
            return this; //return this (for chaining)
        } catch (Exception e) { 

            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public Vector<T> pop() { //remove last element

        var i=this; //start from first element
        for (var a=0; a<this.size()-1; a++) i=i.next; //loop over every element
        i.clear(); //delete its pointer
        return this; //return this (for chaining)
    }

    public Vector<T> cut() { //remove first element

        try {

            if (this.next==null) throw new EmptyVectorException("Empty vector returned null value"); //throw exception if vector is empty
            this.next=next.next; //skip first element
            return this; //return this (for chaining)
        } catch (Exception e) { 

            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public Vector<T> remove(int index) { //remove element at index specified position

        try {

            if (index<0) throw new VectorOutOfBoundsException("Index "+index+" is negative"); //throw exception if negative index
            if (index>this.size()) throw new VectorOutOfBoundsException("Index "+index+" is greater than size "+this.size()); //throw exception if index is larger than Vector size
            var i=this.next; //iterator element from next element (this is just a root for the vector with null value)
            for (int a=0; a<index-1; a++) i=i.next; //scroll the list until index
            i.next=i.next.next; //clear value after index position
            return this; //return this (for chaining)
        } catch (Exception e) { 

            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public Vector<T> shrink(int index) { //remove every element starting from index specified position (resulting Vector will have same size as index)

        try {

            if (index<0) throw new VectorOutOfBoundsException("Index "+index+" is negative"); //throw exception if negative index
            if (index>this.size()) throw new VectorOutOfBoundsException("Index "+index+" is greater than size "+this.size()); //throw exception if index is larger than Vector size
            var i=this.next; //iterator element from next element (this is just a root for the vector with null value)
            for (int a=0; a<index-1; a++) i=i.next; //scroll the list until index
            i.clear(); //clear every value after index position
            return this; //return this (for chaining)
        } catch (Exception e) { 

            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public Vector<T> clear() { //clear every element in vector

        this.next=null; //reset the first element (every value after it should be erased)
        return this; //return this (for chaining)
    }

    public int indexOf(T value) { //return index of first catch of element (or -1 if not present)

        for (var a=0; a<this.size(); a++) if (this.get(a).equals(value)) return a; //loop over the list and return the index
        return -1; //return default value if not found
    }

    public int lastIndexOf(T value) { //return index of last catch of element (or -1 if not present)

        for (var a=this.size()-1; a>=0; a--) if (this.get(a).equals(value)) return a; //loop over the list and return the index
        return -1; //return default value if not found
    }

    public T get(int index) { //return element in specified position

        try {
            
            if (index<0) throw new VectorOutOfBoundsException("Index "+index+" is negative"); //throw exception if negative index
            if (index>=this.size()) throw new VectorOutOfBoundsException("Index "+index+" is greater than last index "+(this.size()-1)); //throw exception if index is larger than Vector size
            var i=this.next; //iterator element from next element (this is just a root for the vector with null value)
            for (var a=0; a<index; a++) i=i.next; //scroll the list until index or last element
            return i.value; //return element in index position otherwise
        } catch (Exception e) {

            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public T first() { //return element in first position (if exists)
        
        try {

            if (this.next==null) throw new EmptyVectorException("Empty vector returned null value"); //throw exception if vector is empty
            return this.next.value; //return first value otherwise
        } catch (Exception e) {

            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public T last() { //return element in last position (if exists)
        
        try {

            if (this.next==null) throw new EmptyVectorException("Empty vector returned null value"); //throw exception if vector is empty
            var i=this; //iterator element
            while (i.next!=null) i=i.next; //scroll the entire list
            return i.value; //return last value in list
        } catch (Exception e) {

            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public Vector<T> reverse() { //return the inverse of a Vector

        var res=new Vector<T>(); //new Vector
        for (var a: this) res.append(a); //append as first every item of this
        return res; //return new Vector
    }

    public String toString() { //standard method: toString

        if (this.next==null) return "Vector<null>(0) {}"; //empty list header
        String res=""+this.getClass().getSimpleName()+"<"+this.next.value.getClass().getSimpleName()+">("+this.size()+") { "; //data type header
        for (var a: this) res+=(a.toString()+" "); //add elements of vector as string
        return res+"}"; //return vector as string
    }

    public String getData() {

        var res="";
        for (var a: this) res+=(a.toString()+" "); //add elements of vector as string
        return res; //return vector as string
    }

    public boolean equals(Object other) { //standard method: equals

        if (this.size()!=((Vector<?>)other).size()) return false; //vectors are different if not of same size
        if (this.value!=null && ((Vector<?>)other).value!=null && !this.value.equals(((Vector<?>)other).value)) return false; //vectors are not equal if any element is different
        if (this.next!=null && ((Vector<?>)other).next!=null) return this.next.equals(((Vector<?>)other).next); //check if the next element is equal (if exists)
        return true; //vectors are equal if the last element is equal
    }

    public Iterator<T> iterator() { return new VectorIterator(this); } //return a new Iterator over the vector
    
    private class VectorIterator implements Iterator<T> { //Iterator class

        private Vector<T> data; //private reference to the next pointer
        private VectorIterator(Vector<T> v) { this.data=v; } //private constructor for new Iterator
        public boolean hasNext() { return this.data.next!=null; } //Iterator check for next pointer to be set
        
        public T next() { //iterator loop over the Vector
            
            this.data=this.data.next; //go to next pointer
            return this.data.value; //return its value
        }
    }
}
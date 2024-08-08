package DataContainer.Vector;

public class SortableVector<T extends Comparable<T>> extends Vector<T> {

    public SortableVector(T... list) { super(list); }
    public SortableVector() {}
    
    private void exchange(int s1, int s2) { //default exchange algorithm for elements

        var temp=this.get(s2); //create temp value
        this.set(s2, this.get(s1)); //exchange values
        this.set(s1, temp); //restore temp value
    }

    public SortableVector<T> sort() { //sorting algorithm

        for (var i=0; i<this.size(); i++) //loop over every element
            for (var j=i; j<this.size(); j++) //scan every other element
                if (this.get(i).compareTo(this.get(j))>0) this.exchange(i, j); //exchange elements position if they do not compare correctly
        return this; //return this (for chaining)
    }
}
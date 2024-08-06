import DataContainer.Vector;

public class Main {
    
    public static void main(String[] args) {
        
        Vector<Integer> myVector=new Vector<Integer>(10, 9, 8);
        myVector.push(4);
        myVector.append(3);
        myVector.push(2);
        System.out.println("now testing: "+myVector.last());
        System.out.println(myVector);
        for (var i: myVector) System.out.println(i);
        var c=myVector.reverse().remove(1).pop().set(1, -10).pop().push(-30).shrink(4).cut();
        System.out.println(c+"\n"+myVector);
    }
}

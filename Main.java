import DataContainer.*;

public class Main {
    
    public static void main(String[] args) {
        
        Vector<Integer> b=new Vector<Integer>();
        System.out.println("test out");
        b.push(4);
        b.push(9);
        b.push(2);
        b.push(5);
        System.out.println(b.get(3));
        System.out.println(b.get(0));
        b.append(-3);
        System.out.println(b.get(0));
    }
}

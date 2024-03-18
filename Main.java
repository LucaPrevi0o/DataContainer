import DataContainer.*;

public class Main {
    
    public static void main(String[] args) {
        
        Vector<Integer> b=new Vector<Integer>();
        for (int i=0; i<6; i++) b.push(i);
        Vector<Integer> b1=b.copy().reverse().push(12);
        System.out.println(b);
        System.out.println(b1.remove(9));
    }
}

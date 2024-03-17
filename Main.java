import DataContainer.*;

public class Main {
    
    public static void main(String[] args) {
        
        Vector<Integer> b=new Vector<Integer>();
        b.push(4);
        b.push(9);
        b.push(2);
        b.add(1, -4);
        b.push(5);
        b.append(-3);
        for (int a=0; a<b.size(); a++) System.out.println(b.get(a));
    }
}

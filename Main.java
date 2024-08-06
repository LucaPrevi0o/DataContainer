import DataContainer.Tree;
import DataContainer.Vector;

public class Main {
    
    public static void main(String[] args) {
        
        var tree=new Tree<Integer>(new Vector<Integer>(10, 9));
        tree.branch(new Vector<Integer>(3, 4, 5)).branch(new Vector<Integer>(-3, -5, -4));
        tree.getSubTree(0).branch(7, 6, 5).branch(new Vector<Integer>(-11, -8, -5)).branch(0);
        tree.getSubTree(1).branch(new Vector<Integer>(0, 0, 0, 0));
        tree.getSubTree(0).getSubTree(1).branch(new Vector<Integer>(3, 2, 1, 0));
        tree.getSubTree(0).getSubTree(1).branch(new Vector<Integer>(9, 2, 4, 0));
        System.out.println(tree);
    }
}

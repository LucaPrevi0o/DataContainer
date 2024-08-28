import DataContainer.BinaryTree.BinaryTree;
import DataContainer.BinaryTree.SortableBinaryTree;
import DataContainer.Tree.Tree;
import DataContainer.Vector.SortableVector;
import DataContainer.Vector.Vector;

public class Main {
    
    public static void main(String[] args) {

        var v=new Vector<Integer>(3, 6, 4);
        System.out.println(v);

        var n=new SortableVector<Integer>(3, 6, 5).sort();
        System.out.println(n);

        var q=new Tree<Integer>(1, 2, 5).branch(4, 7).branch(1, 3, 4);
        q.getSubTree(0).branch(1, 1).branch(3, 5, 7);
        q.getSubTree(0).getSubTree(1).branch(6, 65, 0, 8);
        q.getSubTree(1).branch(4, 0, 7, 6, 9, 8, 7, 0, 6, 8);
        System.out.println(q);

        var r=new BinaryTree<Integer>(5).pushLeft(6).pushRight(4);
        r.getLeftSubTree().pushLeft(9).pushRight(7);
        System.out.println(r);

        var k=new SortableBinaryTree<Integer>(3).push(5).push(1).push(4);
        System.out.println(k);
    }
}

import DataContainer.Tree.*;
import DataContainer.Vector.SortableVector;

public class Main {
    
    public static void main(String[] args) {
        
        var tree=new Tree<Integer>(10, 9);
        tree.branch(3, 4, 5).branch(-3, -5, -4);
        tree.getSubTree(0).branch(7, 6, 5).branch(-11, -8, -5).branch(0);
        tree.getSubTree(1).branch(0, 0, 0, 0);
        tree.getSubTree(0).getSubTree(1).branch(3, 2, 1, 0).branch(9, 2, 4, 0);
        System.out.println(tree+"\n");

        var sortableVector=new SortableVector<Integer>(1, 3, 2, 5, 9, 4, 0).sort();
        System.out.println(sortableVector+"\n");

        var binTree=new BinaryTree<Integer>(0);
        binTree.pushLeft(1).pushRight(3);
        binTree.getLeftSubTree().pushLeft(23);
        System.out.println(binTree+"\n");

        var sortedBinTree=new SortedBinaryTree<Integer>(5).push(3).push(2).push(4).push(7).push(3).push(6).push(8).push(0);
        System.out.println(sortedBinTree);
    }
}

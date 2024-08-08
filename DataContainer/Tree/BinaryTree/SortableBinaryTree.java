package DataContainer.Tree.BinaryTree;

public class SortableBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {
    
    public SortableBinaryTree(T leaf) { super(leaf); }

    private SortableBinaryTree<T> insert(SortableBinaryTree<T> node, T value) {

        if (node==null) return new SortableBinaryTree<T>(value);
        if (node.leaf.compareTo(value)>0) node.leftBranch=this.insert((SortableBinaryTree<T>)node.leftBranch, value);
        else node.rightBranch=this.insert((SortableBinaryTree<T>)node.rightBranch, value);
        return node;
    }

    public SortableBinaryTree<T> push(T value) { return this.insert(this, value); }
}

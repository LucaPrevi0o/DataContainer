package DataContainer.Tree;

public class SortedBinaryTree<T extends Comparable<T>> {
    
    private T leaf;
    private SortedBinaryTree<T> leftBranch, rightBranch;

    public SortedBinaryTree(T leaf) { this.leaf=leaf; }

    private SortedBinaryTree<T> insert(SortedBinaryTree<T> node, T value) {

        if (node==null) return new SortedBinaryTree<T>(value);
        if (node.leaf.compareTo(value)>0) node.leftBranch=this.insert(node.leftBranch, value);
        else node.rightBranch=this.insert(node.rightBranch, value);
        return node;
    }

    public SortedBinaryTree<T> push(T value) { return this.insert(this, value); }

    public SortedBinaryTree<T> getLeftSubTree() { return this.leftBranch; }
    public SortedBinaryTree<T> getRightSubTree() { return this.rightBranch; }

    private String print(int depth) {

        var res=this.leaf+"\n";
        for (var j=0; j<depth; j++) res+="  ";
        res+="- "+(this.leftBranch==null ? "null" : this.leftBranch.print(depth+1))+"\n";
        for (var j=0; j<depth; j++) res+="  ";
        res+="- "+(this.rightBranch==null ? "null" : this.rightBranch.print(depth+1));
        return res;
    }

    public String toString() {

        var res="SortableTree<"+this.leaf.getClass().getSimpleName()+">\n"+this.leaf+"\n";
        res+="- "+(this.leftBranch==null ? "null" : this.leftBranch.print(1))+"\n";
        res+="- "+(this.rightBranch==null ? "null" : this.rightBranch.print(1));
        return res;
    }
}

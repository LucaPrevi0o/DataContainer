package DataContainer.Tree.BinaryTree;

public class BinaryTree<T> {
    
    protected T leaf;
    protected BinaryTree<T> leftBranch, rightBranch;
    public BinaryTree(T leaf) { this.leaf=leaf; }

    public BinaryTree<T> pushLeft(T value) { 
        
        this.leftBranch=new BinaryTree<T>(value);
        return this;
    }

    public BinaryTree<T> pushRight(T value) { 
        
        this.rightBranch=new BinaryTree<T>(value);
        return this;
    }

    public BinaryTree<T> getLeftSubTree() { return this.leftBranch; }
    public BinaryTree<T> getRightSubTree() { return this.rightBranch; }

    private String print(int depth) {

        var res=this.leaf+"\n";
        for (var j=0; j<depth; j++) res+="  ";
        res+="- "+(this.leftBranch==null ? "null" : this.leftBranch.print(depth+1))+"\n";
        for (var j=0; j<depth; j++) res+="  ";
        res+="- "+(this.rightBranch==null ? "null" : this.rightBranch.print(depth+1));
        return res;
    }

    public String toString() {

        var res=this.getClass().getSimpleName()+"<"+this.leaf.getClass().getSimpleName()+">\n"+this.leaf+"\n";
        res+="- "+(this.leftBranch==null ? "null" : this.leftBranch.print(1))+"\n";
        res+="- "+(this.rightBranch==null ? "null" : this.rightBranch.print(1));
        return res;
    }
}

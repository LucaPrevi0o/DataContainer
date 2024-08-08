package DataContainer.Tree;

import DataContainer.Vector.Vector;

public class Tree<T> {
    
    protected Vector<Tree<T>> branches=new Vector<Tree<T>>();
    protected Vector<T> leaves=new Vector<T>();

    public Tree(T... leaves) { this.leaves=new Vector<T>(leaves); }
    public Tree() {}
    
    public Tree<T> getSubTree(int node) { return this.branches.get(node); }
    public Vector<T> getLeaves() { return leaves; }

    public Tree<T> branch(T... leaves) { 
        
        branches.push(new Tree<T>(leaves));
        return this;
    }

    private String print(int depth) {

        var res=this.leaves.getData();
        for (var i: this.branches) {

            res+="\n";
            for (var j=0; j<depth; j++) res+="  ";
            res+=this.branches.indexOf(i)+") "+i.print(depth+1);
        }
        return res;
    }

    public String toString() {

        var res="Tree<"+this.leaves.get(0).getClass().getSimpleName()+">\n"+this.leaves.getData();
        for (var i: this.branches) res+="\n"+this.branches.indexOf(i)+") "+i.print(1);
        return res;
    }
}

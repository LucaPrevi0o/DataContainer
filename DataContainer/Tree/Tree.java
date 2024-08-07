package DataContainer.Tree;

import DataContainer.Vector.Vector;

public class Tree<T> {
    
    private Vector<Tree<T>> branch=new Vector<Tree<T>>();
    private Vector<T> leaves=new Vector<T>();

    public Tree(T... leaves) { this.leaves=new Vector<T>(leaves); }
    public Tree() {}
    public Tree<T> getSubTree(int node) { return this.branch.get(node); }
    public Vector<T> getLeaves() { return leaves; }

    public Tree<T> branch(T... leaves) { 
        
        branch.push(new Tree<T>(leaves));
        return this;
    }

    private String print(int depth) {

        var res=this.leaves.getData()+"\n";
        for (var i: this.branch) {
            
            for (var j=0; j<depth; j++) res+="  ";
            res+=this.branch.indexOf(i)+") "+i.print(depth+1);
        }
        return res;
    }

    public String toString() {

        var res="Tree<"+this.leaves.get(0).getClass().getSimpleName()+">\n"+this.leaves.getData()+"\n";
        for (var i: this.branch) res+=this.branch.indexOf(i)+") "+i.print(1);
        return res;
    }
}

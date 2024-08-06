package DataContainer;

public class Tree<T> {
    
    private Vector<Tree<T>> branch=new Vector<Tree<T>>();
    private Vector<T> leaves=new Vector<T>();

    public Tree(Vector<T> leaves) { this.leaves=leaves; }
    public Tree(T... leaves) { this.leaves=new Vector<T>(leaves); }
    public Tree() {}
    public Tree<T> getSubTree(int node) { return this.branch.get(node); }
    public Vector<T> getLeaves() { return leaves; }

    public Tree<T> branch(Vector<T> newBranch) { 
        
        branch.push(new Tree<T>(newBranch));
        return this;
    }

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

        var res=this.leaves.getData()+"\n";
        for (var i: this.branch) res+=this.branch.indexOf(i)+") "+i.print(1);
        return res;
    }
}

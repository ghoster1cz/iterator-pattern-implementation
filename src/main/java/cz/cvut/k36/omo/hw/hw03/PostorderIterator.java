package cz.cvut.k36.omo.hw.hw03;
public class PostorderIterator implements CustomIterator{
    private final Node root;
    private Node last = null;
    private Node now = null;

    PostorderIterator(Node root){
        this.root = root;
    }

    public boolean hasNext() {
        if(last == root) {
            return false;
        }
        return true;
    }

    public int next() {
        if(last == null){
            last = root;
            while(last.getLeft() != null || last.getRight() != null) {
                if(last.getLeft() != null){
                    last = last.getLeft();
                } else if(last.getRight() != null){
                    last = last.getRight();
                }
            }
            return last.getContents();
        } else {
            now = last.getParent();
            if(last == now.getRight()){
                last = now;
                return last.getContents();
            } else {
                if(now.getRight() == null){
                    last = now;
                    return last.getContents();
                }
                last = now.getRight();
                while(last.getLeft() != null || last.getRight() != null) {
                    if(last.getLeft() != null){
                        last = last.getLeft();
                    } else if(last.getRight() != null){
                        last = last.getRight();
                    }
                }
            }

            return last.getContents();
        }
    }
}

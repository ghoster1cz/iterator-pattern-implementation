package cz.cvut.k36.omo.hw.hw03;
public class PreorderIterator implements CustomIterator{
    private final Node root;
    private Node last = null;
    private Node now = null;

    PreorderIterator(Node root){
        this.root = root;
    }

    public boolean hasNext() {
        if(last == null){
            return true;
        }

        if(last == root){
            if(root.getLeft()!=null || root.getRight()!=null) {
                return true;
            } else {
                return false;
            }
        }

        if(last.getLeft() != null) {
            return true;
        }

        Node lastTemp = last;
        Node nowTemp = lastTemp;

        while (nowTemp.getRight() == null || lastTemp == nowTemp.getRight()) {
            lastTemp = nowTemp;
                nowTemp = nowTemp.getParent();
                if(nowTemp == root){
                    if(lastTemp == root.getRight() || root.getRight() == null){
                        return false;
                    }
                }
        }
        return true;
    }

    public int next() {
        if(!hasNext()){
            throw new RuntimeException("Iterator has no next!");
        }

        if(last == null) {
            last = root;
            return last.getContents();
        } else if (last.getLeft() != null){
            last = last.getLeft();
            return last.getContents();
        } else if (last.getRight() != null) {
            last = last.getRight();
            return last.getContents();
        } else {
            now = last;
            while (now.getRight() == null || last == now.getRight()) {
                last = now;
                now = now.getParent();
            }
            last = now.getRight();
            return last.getContents();
        }
    }
}

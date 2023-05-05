package cz.cvut.k36.omo.hw.hw03;


// 1. If left -> go left
// 2. Return self
// 3. If right -> go right
// go to parent
//      check if child is left or right
//      if right end
/*
if(last = null){
    if(left ! null){
        if(left has next){
            last = left
            return left next
        }
    } else {
        last this
        return
    }
}

if(last = left) {
    last = this
    return
}

if(last = this){
    if(right ! null){
        if(right has next) {
            return right next
        }
    }
}

has next = false
 */


public class InorderIterator implements CustomIterator{
    private final Node root;
    private Node last = null;
    private Node now = null;

    public InorderIterator(Node root){
        this.root = root;
    }

    public boolean hasNext() {
        if(last == null) {
            return true;
        }

        if(last.getRight() != null){
            return true;
        }

        Node lastTemp = this.last;
        Node nowTemp = lastTemp.getParent();

        if (lastTemp == root) {
            return lastTemp.getRight() != null;
        }

        while (lastTemp != nowTemp.getLeft()){
            if (nowTemp == root && lastTemp == root.getRight()) {
                return false;
            }
            lastTemp = nowTemp;
            nowTemp = nowTemp.getParent();
        }

        return true;
        }

    public int next() {
        if(!hasNext()){
            throw new RuntimeException("Iterator has no next!");
        }
        if(last == null) {
            Node node = root;
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            last = node;
            return node.getContents();
        }

        else if(last.getRight() != null) {
            Node node = last.getRight();
            while (node.getLeft() != null) {
                node = node.getLeft();
            }

            last = node;
            return node.getContents();
        }

        else {
            now = last.getParent();
            while (last != now.getLeft()){
                last = now;
                now = now.getParent();
            }
            last = now;
            return now.getContents();
        }
    }
}

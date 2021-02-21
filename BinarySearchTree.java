
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    public void insert(E data) {
        root=insert(data, root);
    }

    public Node<E> insert(E data, Node<E> curr) {
        Node<E> temp = new Node<E>(data);
        if (curr == null) {
            return temp;
        }
            if (data.compareTo(curr.data) < 0) {
                curr.left = insert(data, curr.left);
            } else if (data.compareTo(curr.data) > 0) {
                curr.right = insert(data, curr.right);
            }
            return curr;

    }

    public void remove(E data){
        root=remove(data, root);
    }

    public Node<E> remove(E data, Node<E> curr) {
        if(curr==null) {
            return curr;
        }
        if(data.compareTo(curr.data)<0){
            curr.left=remove(data, curr.left);
        }else if(data.compareTo(curr.data)>0){
            curr.right=remove(data, curr.right);
        }else{
            if(curr.left==null){
                return curr.right;
            }else if(curr.right==null){
                return curr.left;
            }
            curr.data=findMin(curr.right);
            curr.right= remove(data, curr.right);
        }
        return curr;
    }

    public E findMin(Node<E> curr){
        E min= curr.data;
        while(curr.left!=null){
            min=curr.left.data;
            curr=curr.left;
        }
        return min;
    }

    public boolean search(E data) {
        return search(data, root);
    }

    public boolean search(E data, Node<E> curr) {
        if (curr == null) {
            return false;
        }else if (data.compareTo(curr.data) == 0) {
            return true;
        }  else if (data.compareTo(curr.data) > 0) {
            return search(data, curr.right);
        } else{
            return search(data, curr.left);
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Stack<Node<E>> it = new Stack<Node<E>>();
            private void addLeft(Node<E> curr){
                while(curr!=null){
                    it.push(curr);
                    curr=curr.left;
                }
            }

            public boolean hasNext(){
                if(it.isEmpty()){
                    return false;
                }else{ return true;}
            }

            @Override
            public E next(){
                Node<E> temp = it.pop();
                Node<E> r =temp.right;
                    while(r!=null){
                        it.push(r);
                        r=r.left;
                    }
                    return temp.data;
            }
        };
    }

}
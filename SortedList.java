/*
 *
 *  SortedList.java
 *
 */

import java.util.Iterator;
import java.util.Random;


public class SortedList<E extends Comparable<? super E>> extends List<E> {
    public void insert(E data) {
        insert(null, head, data);
    }
    public void insert(Node<E> prev, Node<E> curr, E data){
        Node<E> temp = new Node<E>(data);
        if(prev == null && curr==null) {
            head = temp;
        }
        else if(prev == null && curr.data.compareTo(data)>= 0){
            temp.next = head;
            head = temp;
        }
        else if(curr == null && prev.data.compareTo(data) <= 0){
            prev.next = temp;
        }
        else if(prev != null && curr != null && prev.data.compareTo(data)<= 0 && curr.data.compareTo(data) > 0){
            temp.next = curr;
            prev.next = temp;
        }
        else insert(curr, curr.next, data);
    }

    public void remove(E data) {
           head= remove(data, head);

    }

    public Node remove(E data, Node<E> curr){
        if(curr==null){
            return null;
        }else if(curr.data==data){
            return curr.next;
        }else{
            curr.next=remove(data, curr.next);
        }
        return curr;
        }


    public E retrieve(int index) {
        //make recursive
        /*int i = 0;
        for (Node<E> curr = head; curr != null; curr = curr.next, ++i) {
            if (i == index) {
                return curr.data;
            }
        }
        return null;*/
        if(head!=null) {
            return retrieve(index, head);
        }else return null;
    }

    public E retrieve(int index, Node<E> curr){
        if(curr!=null) {
            if(index==0){
                return curr.data;
            }else return retrieve(index-1, curr.next);
        }
        return null;
    }

    public boolean search(E data) {
        return search(data, head);
    }
    public boolean search(E data, Node<E> curr){
        if(data==curr.data){
            return true;
        }else if (curr.next!=null){
            return search(data, curr.next);
        }else{
            return false;
        }
    }





    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            private Node<E> curr = head;
        };
    }

    public static void main(String[] args) {
        Random rand = new Random(1);
        SortedList<Integer> list = new SortedList<Integer>();
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        long start, stop;

        System.out.println("insert");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            list.insert(rand.nextInt(num));
            System.out.print(i + ": ");
            for (int j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //rand = new Random(1);
        System.out.println("remove");

        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(num);
            list.remove(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        stop = System.currentTimeMillis();

        System.out.println(stop-start);


        int j;
        for (int i = 0; list.retrieve(i) != null; ++i) {
            System.out.println((j = list.retrieve(i)) + " => " + list.search(j));
        }

        for (int i = 0; i < num; ++i) {
            System.out.println(i + " => " + list.search(i));
        }
    }
}


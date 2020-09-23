package ru.study.lesson.iterator;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node head;
    private Node last;
    private int size;


    public void add(T val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            last = node;
        }else{
            last.node = node;
            last = node;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        Node curNode = head;
        int curIndex = 0;
        while(curNode!=null && curIndex< index){
            curNode = curNode.node;
            curIndex++;
        }
        if(curNode!=null){
            return curNode.val;
        }
        throw new NullPointerException("No such index");
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public MyIterator test(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{

        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            return get(currentIndex++);
        }
    }

    private class Node{
        T val;
        Node node;

        public Node(T val) {
            this.val = val;
        }
    }
}

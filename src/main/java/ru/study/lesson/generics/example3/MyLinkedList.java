package ru.study.lesson.generics.example3;

public class MyLinkedList<T> {

    private Node head;
    private Node last;


    public void add(T val){
        Node node = new Node(val);

    }

    private class Node{
        T val;
        Node node;

        public Node(T val) {
            this.val = val;
        }
    }
}

package edu.grinnell.csc207.genericslab;

import java.lang.classfile.TypeAnnotation.TargetInfo;

import org.w3c.dom.Node;

public class LinkedListGenerics<T> implements ListInterface<T>{
/**
 * A linked implementation of the list ADT.
 */
    private static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> first;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedListGenerics (){
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    @Override
    public void add(T value) {
        if (first == null) {
            first = new Node<T>(value, null);
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<T>(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        int sz = 0;
        Node<T> cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    @Override
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    @Override
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }
    /**
     * Inserts sep between each element of the list.
     * @param sep element of Type T 
     */
    public void intersperse(T sep) {
        if (first == null || first.next == null) {
            return;
        }
        Node<T> cur = first;
        Node<T> next = cur.next;
        while(cur.next != null){
            cur.next = new Node<T>(sep, next); // assign new node of sep after cur (in between cur and next)
            cur = next; // reassign cur to next (after sep node)
            next = next.next; // move next to its next node 
        }
    }

    /**
     * maximum function
     * @return maximum element in list of types T
     * Because we are implementing this in the generic class, we can't know what type we are gonna get and 
     * Thus we can't perform any comparisons.
     */
    public T maximum(){
        throw new UnsupportedOperationException();
    }
    
    /**
     * @return a string representation of the list
     */
    public String toString(){
        String ret = "";
        Node<T> cur = first;
        while(cur != null){
            ret += String.valueOf(cur.value);
            cur = cur.next;
        }
        return ret;
    }

    /**
     * sorts the list using insertion sort
     * This method can't be implemented by a similar argument to why maximum can't be implemented. We can't compare types T
     * because we don't know what they are going to be until runtime
     */
    public void insertionSort(){
        throw new UnsupportedOperationException();
    }
}


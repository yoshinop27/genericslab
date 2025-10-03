package edu.grinnell.csc207.genericslab;

public interface ListInterface<T>{
    public void add(T value);
    public T get(int index);
    public int size();
    public T remove(int index);
}

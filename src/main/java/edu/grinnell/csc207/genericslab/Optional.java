package edu.grinnell.csc207.genericslab;

import java.util.NoSuchElementException;

/**
 * An Optional<@T> is either empty or holds a single value of type @T.
 * 
 * @param T the type of value potentially held by this <code>Optional</code>.
 */
public class Optional<T> {
    /* TODO: fill me in with implementation! */
    private T value;  
    private Optional(){};
    /**
     * Method to instantiate a new Optional of type T thats empty
     * @return new optional<T> thats empty
     */
    public static <T> Optional<T> empty(){
        return new Optional<T>();
    }
    /**
     * Creates a non-empty Optional<T> object
     * @param value of type T gets assigned to objects value
     * @return an optional<T> with value of type T
     */
    public static <T> Optional<T> of(T value){
        Optional<T> cur = new Optional<T>();
        cur.value = value;
        return cur;
    }

    /**
     * 
     * @return true if empty false otherwise
     */
    public boolean isEmpty(){
        if (value == null){
            return true;
        }
        return false;
    }

    /**
     * 
     * @return true if value is present false otherwise
     */
    public boolean isPresent(){
        if (isEmpty() == true){
            return false;
        }
        return true;
    }

    /**
     * 
     * @return value of this instance or throws error if no value is present
     */
    public T get(){
        if (value == null){
            throw new NoSuchElementException();
        }
        return value;
    }

    /**
     * @param other of type T
     * @return value of this instance or other if value is null
     */
    public T orElse (T other){
        if (value == null){
            return other;
        }
        return value;
    }
}


// Question 4.1
/*
 * Calling the get function and it returning null can be potentially ambiguous as we don't know if the null
 * that was returned was explicit, i.e it was a stored value that was mapped to the key we requested. Or if the null
 * value was a result of requesting a key with no mapping. 
 */
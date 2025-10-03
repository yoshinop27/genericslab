package edu.grinnell.csc207.genericslab;

/**
 * An Optional<@T> is either empty or holds a single value of type @T.
 * 
 * @param T the type of value potentially held by this <code>Optional</code>.
 */
public class Optional<T> {
    /* TODO: fill me in with implementation! */  
}

// Question 4.1
/*
 * Calling the get function and it returning null can be potentially ambiguous as we don't know if the null
 * that was returned was explicit, i.e it was a stored value that was mapped to the key we requested. Or if the null
 * value was a result of requesting a key with no mapping. 
 */
package it.unibo.es2;

import java.util.List;

public interface Logics {
    /**
     * Number of slots.
     * @return the number of slots
     */
    int size();

    /**
     *  
     * @return ordered booleans stating whether a button has to show the "*"
     */
    List<Boolean> pressedButton();

    

}

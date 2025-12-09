package it.unibo.es2;

public interface Logics {
    /**
     * Number of slots.
     * @return the number of slots
     */
    int size();

    /**
     * Tells whether a cell is a "*" or not
     * @param row the row of the cell
     * @param col the column of the cell
     * @return true if a cell is a "*"
     */
    boolean isStar(int row, int col);

    /**
     * Changes the cell
     * @param row the row of the cell
     * @param col the column of the cell
     */
    void trigger(int row, int col);

    /**
     * True if it is time to quit (i.e. all slots in a row or in a column show "*")
     * @return whether it's time to quit
     */
    boolean toQuit();

}

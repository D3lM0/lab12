package it.unibo.es3;

/**
 * Interface modelling logics for the next-button-based GUI.
 */
public interface Logics {
    /**
     * 
     * @return the width of the grid.
     */
    int width();

    /**
     * Triggers the button changing what's inside it (i.e. puts a "*" in it).
     */
    void trigger();

    /**
     * Decides whether it is time to quit.
     * 
     * @return true if it is time to quit (i.e. whether all the cells are "*").
     */
    boolean toQuit();

    /**
     * Verifies if a cell is a "*" or not.
     * 
     * @param row the row of the cell.
     * 
     * @param col the column of the cell.
     * 
     * @return true if a cell is "*".
     */
    boolean isStar(int row, int col);

    /**
     * Verifies if a cell has a neighbour cell active (i.e. if the cell is "*")
     * 
     * @param row the row of the cell.
     * 
     * @param col the colun of the cell.
     * 
     * @return true if the cell has an active neighbour cell.
     */
    boolean hasActiveNeighbour(int row, int col);

    /**
     * Actives a number n of cells. 
     * 
     * @param n the number of cells to activate.
     */
    void activateRandomCells(int n);
}

package it.unibo.es2;

/**
 * Class implementing the Logics interface.
 */
public class LogicsImpl implements Logics {
    private final int size; /*Number of rows or cols */
    private final boolean[][] grid; /*Double matrix to save the state of each cell of the GUI */

    /**
     * Constructor.
     * 
     * @param size the number of rows or cols 
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.grid = new boolean[size][size];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStar(final int row, final int col) {
        return grid[row][col];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trigger(final int row, final int col) {
        grid[row][col] = !grid[row][col];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        /*Check rows */
        for (int r = 0; r < size; r++) {
            boolean full = true;
            for (int c = 0; c < size; c++) {
                if (!grid[r][c]) {
                    full = false;
                    break;
                }
            }
            if (full) {
                return true;
            }
        }

        /*Check columns */
        for (int c = 0; c < size; c++) {
            boolean full = true;
            for (int r = 0; r < size; r++) {
                if (!grid[r][c]) {
                    full = false;
                    break;
                }
            }
            if (full) {
                return true;
            }
        }

        return false;
    }
}

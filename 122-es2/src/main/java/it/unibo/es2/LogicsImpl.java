package it.unibo.es2;



public class LogicsImpl implements Logics{
    private int size; /*Number of rows or cols */
    private boolean[][] grid;

    /**
     * Constructor.
     * @param size the number of rows or cols 
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.grid = new boolean[size][size];
    }

    @Override
    public int size() {
        return size;        
    }

    @Override
    public boolean isStar(int row, int col) {
        return grid[row][col];
    }

    @Override
    public void trigger(int row, int col) {
        grid[row][col] = !grid[row][col];
    }

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

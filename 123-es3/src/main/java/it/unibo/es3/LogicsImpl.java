package it.unibo.es3;

import java.util.Random;

public class LogicsImpl implements Logics {
    private static final int INITIAL_CELLS = 3;
    private int width;
    private boolean[][] grid;
    private Random rng = new Random();

    public LogicsImpl(final int width) {
        this.width = width;
        this.grid = new boolean[width][width];
        activateRandomCells(INITIAL_CELLS);
    }

    @Override
    public int width() {
        return this.width;
    }

    @Override
    public void trigger() {
        boolean[][] next = new boolean[width][width];

        for (int row = 0; row < width; row++) {
            for (int col = 0; col < width; col++) {
                next[row][col] = grid[row][col] || hasActiveNeighbor(row, col);
            }
        }

        grid = next;
    }

    @Override
    public boolean toQuit() {
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < width; col++) {
                if (!grid[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isStar(int row, int col) {
        return grid[row][col];
    }

    @Override
    public boolean hasActiveNeighbor(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasActiveNeighbor'");
    }

    @Override
    public void activateRandomCells(final int n) {
        int count = 0;

        while(count < n) {
            int row = rng.nextInt(width);
            int col = rng.nextInt(width);
            if(!grid[row][col]) {
                grid[row][col] = true;
                count++;
            }
        }
    }

}

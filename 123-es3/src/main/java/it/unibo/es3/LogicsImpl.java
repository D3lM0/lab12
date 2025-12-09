package it.unibo.es3;

import java.util.Random;

public class LogicsImpl implements Logics {
    private static final int INITIAL_CELLS = 3;
    private final int width;
    private boolean[][] grid;
    private final Random numberGenerator = new Random();

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
                next[row][col] = grid[row][col] || hasActiveNeighbour(row, col);
            }
        }

        grid = next;
    }

    @Override
    public boolean toQuit() {
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < width; col++) {
                if (!isStar(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isStar(final int row, final int col) {
        return grid[row][col];
    }

    @Override
    public boolean hasActiveNeighbour(final int row, final int col) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue; /*Skips the cell itself */
                }

                final int nr = row + dx;
                final int nc = col + dy;

                if (nr >= 0 && nr < width && nc >= 0 && nc < width) {
                    if (isStar(nr, nc)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void activateRandomCells(final int n) {
        int count = 0;

        while(count < n) {
            final int row = numberGenerator.nextInt(width);
            final int col = numberGenerator.nextInt(width);
            if(!isStar(row, col)) {
                grid[row][col] = true;
                count++;
            }
        }
    }

}

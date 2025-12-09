package it.unibo.es3;

public interface Logics {
    int width();

    void trigger();

    boolean toQuit();

    boolean isStar(int row, int col);

    boolean hasActiveNeighbour(int row, int col);

    void activateRandomCells(int n);
}

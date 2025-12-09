package it.unibo.es3;

public interface Logics {
    int size();

    void trigger(int row, int col);

    boolean toQuit();

    boolean isStar();

}

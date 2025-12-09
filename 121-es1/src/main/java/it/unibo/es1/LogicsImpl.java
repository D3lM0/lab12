package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {
    private int size;
    private List<Integer> values;
    private List<Boolean> enabledStates;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.values = new ArrayList<>(size);
        this.enabledStates= new ArrayList<>(size);
        for (int i = 0; i < this.size; i++) {
            this.values.add(0);
            this.enabledStates.add(true);
        } 
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
    public List<Integer> values() {
        return List.copyOf(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return List.copyOf(enabledStates);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        if(!enabledStates.get(elem)) {
            return this.values.get(elem);
        }

        final int newValue = this.values.get(elem) + 1;
        this.values.set(elem, newValue);

        if(newValue == size) {
            enabledStates.set(elem, false);
        }

        return newValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        String result = "<<";
        for (int i = 0; i < size; i++) {
            result += this.values.get(i);
            if (i < size - 1) {
                result += "|";
            }
        }
        result += ">>";
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        final int finalValue = values.get(0);
        for (final int v : values) {
            if(v != finalValue) {
                return false;
            }
        }
        return true;
    }
}

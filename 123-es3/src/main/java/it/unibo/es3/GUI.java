package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        final Logics logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        final JButton next = new JButton(">");
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(next, BorderLayout.SOUTH);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final JButton button = new JButton(" ");
                button.setEnabled(false);
                this.cells.add(button);
                panel.add(button);
            }
        }
        updateView(logics, width);
        pack();
        next.addActionListener(e -> {
            logics.trigger();
            updateView(logics, width);

            if (logics.toQuit()) {
                dispose();
            }
        });
        this.setVisible(true);
    }

    /**
     * Updates the view of the GUI.
     * 
     * @param logics the logics used.
     * 
     * @param width the size of the grid.
     */
    private void updateView(Logics logics, int width) {
        for(int row = 0; row < width; row++) {
            for (int col = 0; col < width; col++) {
                JButton b = cells.get(row * width + col);
                b.setText(logics.isStar(row, col) ? "*" : " ");
            }
        }
    }
}

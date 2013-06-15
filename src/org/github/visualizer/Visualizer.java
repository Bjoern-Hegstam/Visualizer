package org.github.visualizer;

import javax.swing.*;
import java.awt.*;

public class Visualizer extends JFrame {

    private SpiralModelPanel modelPanel;

    public Visualizer(int width, int height) {
        modelPanel = new SpiralModelPanel();
        modelPanel.setPreferredSize(new Dimension(width, height));
        modelPanel.setDoubleBuffered(true);

        addKeyListener(modelPanel);

        setLayout(new BorderLayout());
        add(modelPanel, BorderLayout.CENTER);
        pack();
    }

    public static void main(String[] args) {
        //TODO: CLI for setting width and height of image

        // Generate image
        int width = 800;
        int height = 600;

        JFrame frame = new Visualizer(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}

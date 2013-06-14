package org.github.visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Visualizer extends JFrame implements KeyListener {
    private static final int GRID_UNIT_WIDTH = 16;
    private static final int GRID_UNIT_HEIGHT = 16;

    private SpiralModelPanel modelPanel;

    public Visualizer(int width, int height) {
        modelPanel = new SpiralModelPanel();
        modelPanel.setPreferredSize(new Dimension(width, height));
        modelPanel.setDoubleBuffered(true);
        modelPanel.getModel().setOriginX(width / 2);
        modelPanel.getModel().setOriginY(height / 2);

        setLayout(new BorderLayout());
        add(modelPanel, BorderLayout.CENTER);
        pack();

        addKeyListener(this);
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

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        double dAnglePerRadialUnit = 0.001;
        double dAngleScale = 0.01;
        double dX = 10;
        double dY = 10;

        if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_LEFT) {
            modelPanel.getModel().setAnglePerRadialUnit(modelPanel.getModel().getAnglePerRadialUnit() - dAnglePerRadialUnit);
            repaint();
        } else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
            modelPanel.getModel().setAnglePerRadialUnit(modelPanel.getModel().getAnglePerRadialUnit() + dAnglePerRadialUnit);
            repaint();
        } else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_UP) {
            modelPanel.getModel().setAngleScale(modelPanel.getModel().getAngleScale() - dAngleScale);
            repaint();
        } else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
            modelPanel.getModel().setAngleScale(modelPanel.getModel().getAngleScale() + dAngleScale);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            modelPanel.getModel().setOriginX(modelPanel.getModel().getOriginX() - dX);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            modelPanel.getModel().setOriginX(modelPanel.getModel().getOriginX() + dX);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            modelPanel.getModel().setOriginY(modelPanel.getModel().getOriginY() - dY);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            modelPanel.getModel().setOriginY(modelPanel.getModel().getOriginY() + dY);
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

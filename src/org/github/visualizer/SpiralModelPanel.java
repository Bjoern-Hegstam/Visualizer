package org.github.visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Björn Hegstam
 *         Date: 2013-06-13
 *         Time: 17:44
 *         To change this template use File | Settings | File Templates.
 */
public class SpiralModelPanel extends JPanel implements KeyListener{
    private SpiralModel spiral;
    private Translation translation;
    private Rotation rotation;
    private ColorModel model; // Outermost ColorModel

    private DistributedImageDrawer drawer;

    public SpiralModelPanel() {
        spiral = new SpiralModel();
        rotation = new Rotation(spiral);
        translation = new Translation(rotation);
        model = translation;

        drawer = new DistributedImageDrawer();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawer.fill((Graphics2D)g, model);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        double dAnglePerRadialUnit = 0.001;
        double dAngleScale = 0.01;
        double dX = 10;
        double dY = 10;
        double dAngle = Math.PI / 10;

        if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_LEFT) {
            spiral.setAnglePerRadialUnit(spiral.getAnglePerRadialUnit() - dAnglePerRadialUnit);
            repaint();
        } else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
            spiral.setAnglePerRadialUnit(spiral.getAnglePerRadialUnit() + dAnglePerRadialUnit);
            repaint();
        } else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_UP) {
            spiral.setAngleScale(spiral.getAngleScale() - dAngleScale);
            repaint();
        } else if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
            spiral.setAngleScale(spiral.getAngleScale() + dAngleScale);
            repaint();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_LEFT) {
            rotation.offsetAngle(dAngle);
            repaint();
        } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rotation.offsetAngle(-dAngle);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            translation.offsetX(dX);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            translation.offsetX(-dX);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            translation.offsetY(dY);
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            translation.offsetY(-dY);
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

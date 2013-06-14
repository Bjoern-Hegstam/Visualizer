package org.github.visualizer;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Björn Hegstam
 *         Date: 2013-06-13
 *         Time: 17:44
 *         To change this template use File | Settings | File Templates.
 */
public class SpiralModelPanel extends JPanel{
    private SpiralModel model;
    private DistributedImageDrawer drawer;

    public SpiralModel getModel() {
        return model;
    }

    public SpiralModelPanel() {
        model = new SpiralModel(0, 0);
        drawer = new DistributedImageDrawer();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawer.fill((Graphics2D)g, model);
    }
}

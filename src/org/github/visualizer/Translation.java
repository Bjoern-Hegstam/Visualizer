package org.github.visualizer;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Björn Hegstam
 *         Date: 2013-06-15
 *         Time: 08:48
 *         To change this template use File | Settings | File Templates.
 */
public class Translation implements ColorModel {
    private double dx;
    private double dy;
    private ColorModel model;

    public void offsetX(double dx) {
        this.dx += dx;
    }

    public void offsetY(double dy) {
        this.dy += dy;
    }

    public Translation(ColorModel model) {
        this.model = model;
        dx = dy = 0;
    }

    @Override
    public Color compute(double x, double y) {
        return model.compute(x + dx, y + dy);
    }
}

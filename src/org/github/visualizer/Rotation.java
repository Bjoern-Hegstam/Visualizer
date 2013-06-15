package org.github.visualizer;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Björn Hegstam
 *         Date: 2013-06-15
 *         Time: 09:03
 *         To change this template use File | Settings | File Templates.
 */
public class Rotation implements ColorModel {
    private ColorModel model;
    private double angle;

    public void offsetAngle(double da) {
        angle += da;
    }

    public Rotation(ColorModel model) {
        this.model = model;
        angle = 0;
    }

    @Override
    public Color compute(double x, double y) {
        return model.compute(x * Math.cos(angle) - y * Math.sin(angle),
                x * Math.sin(angle) + y * Math.cos(angle));
    }
}

package org.github.visualizer;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Björn Hegstam
 *         Date: 2013-06-13
 *         Time: 17:11
 *         To change this template use File | Settings | File Templates.
 */
public class SpiralModel implements ColorModel {
    private double anglePerRadialUnit = 0.01;
    private double angleScale = 0;
    private double originX;

    public double getAnglePerRadialUnit() {
        return anglePerRadialUnit;
    }

    public void setAnglePerRadialUnit(double anglePerRadialUnit) {
        this.anglePerRadialUnit = anglePerRadialUnit;
    }

    public double getAngleScale() {
        return angleScale;
    }

    public void setAngleScale(double angleScale) {
        this.angleScale = angleScale;
    }

    public double getOriginX() {
        return originX;
    }

    public void setOriginX(double originX) {
        this.originX = originX;
    }

    public double getOriginY() {
        return originY;
    }

    public void setOriginY(double originY) {
        this.originY = originY;
    }

    private double originY;

    public SpiralModel(double originX, double originY) {
        this.originX = originX;
        this.originY = originY;
    }

    @Override
    public Color compute(double x, double y) {
        x -= originX;
        y -= originY;

        double angle = Math.atan2(-y, x);
        double radius = Math.sqrt(x * x + y * y);

        float hue = (float) (angleScale * (angle + Math.PI) / (2 * Math.PI) + anglePerRadialUnit * radius);
        float saturation = 1f;
        float brightness = 1f;

        return Color.getHSBColor(hue,saturation, brightness);
    }
}

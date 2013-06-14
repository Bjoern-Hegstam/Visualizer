package org.github.visualizer;

import java.awt.Color;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Björn Hegstam
 *         Date: 2013-06-13
 *         Time: 17:10
 *         To change this template use File | Settings | File Templates.
 */
public interface ColorModel {
    public Color compute(double x, double y);
}

package org.github.visualizer;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Björn Hegstam
 *         Date: 2013-06-13
 *         Time: 15:47
 *         To change this template use File | Settings | File Templates.
 */
public class ImageWorker implements Runnable {
    private final Graphics2D graphics;
    private Rectangle workArea;
    private ColorModel colorModel;

    public ImageWorker(Graphics2D graphics, Rectangle workArea, ColorModel colorModel) {
        this.graphics = graphics;
        this.workArea = workArea;
        this.colorModel = colorModel;
    }

    @Override
    public void run() {
        BufferedImage image = new BufferedImage(workArea.width, workArea.height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = image.createGraphics();
        //g.setColor(color);

        for (int x = 0; x < workArea.width; x++) {
            for (int y = 0; y < workArea.height; y++) {
                Color col = colorModel.compute(x + workArea.x, y + workArea.y);
                image.setRGB(x, y, col.getRGB());
            }
        }

        synchronized (graphics) {
            graphics.drawImage(image, workArea.x, workArea.y, null);
        }
    }
}

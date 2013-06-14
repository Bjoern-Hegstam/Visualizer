package org.github.visualizer;

import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class DistributedImageDrawer implements Serializable {
    private static final int UNIT_WIDTH = 32;
    private static final int UNIT_HEIGHT = 32;

    public void fill(Graphics2D graphics, ColorModel colorModel) {
        int width = graphics.getClipBounds().width;
        int height = graphics.getClipBounds().height;

        java.util.List<Thread> threads = new LinkedList<>();
        for (int x = 0; x < width; x += UNIT_WIDTH) {
            for (int y = 0; y < height; y += UNIT_HEIGHT) {
                Rectangle workArea = new Rectangle(x,
                        y,
                        (width - x) > UNIT_WIDTH ? UNIT_WIDTH : width - x,
                        (height - y) > UNIT_HEIGHT ? UNIT_HEIGHT : height - y);

                ImageWorker worker = new ImageWorker(graphics,
                        workArea,
                        colorModel);
                Thread thread = new Thread(worker);
                thread.start();
                threads.add(thread);
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
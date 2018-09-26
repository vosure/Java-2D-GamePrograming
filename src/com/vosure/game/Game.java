package com.vosure.game;

import com.vosure.game.graphics.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {

    private static int width = 300;
    private static int height = width / 16 * 9;
    private static int scale = 3;

    private Thread thread;
    private boolean running;

    private Renderer renderer;

    private Graphics g = null;

    private BufferStrategy bs;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();


    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        renderer = new Renderer(width, height, pixels);

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("No Game No Life");
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        createBufferStrategy(3);
        bs = getBufferStrategy();
    }

    private void render() {
        g = bs.getDrawGraphics();

        renderer.clear();
        renderer.render();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }

    private void update() {

    }

    private synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            update();
            render();
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }
}

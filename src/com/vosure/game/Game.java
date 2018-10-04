package com.vosure.game;

import com.vosure.game.graphics.Renderer;
import com.vosure.game.input.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {

    private static int width = 300;
    private static int height = width / 16 * 9;
    private static int scale = 3;
    private  int x = 0, y = 0;

    private Thread thread;
    private boolean running;

    private Renderer renderer;

    private JFrame frame = null;
    private Graphics g = null;
    private BufferStrategy bs;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();


    public Game() {
        setPreferredSize(new Dimension(width * scale, height * scale));

        renderer = new Renderer(width, height, pixels);

        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("No Game No Life");
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        addKeyListener(new Keyboard());

        createBufferStrategy(3);
        bs = getBufferStrategy();
    }

    private void render() {
        g = bs.getDrawGraphics();

        renderer.clear();
        renderer.render(x ,y);

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }

    private void update() {
        if (Keyboard.isKeyPressed(KeyEvent.VK_UP) || Keyboard.isKeyPressed(KeyEvent.VK_W)) y--;
        if (Keyboard.isKeyPressed(KeyEvent.VK_DOWN) || Keyboard.isKeyPressed(KeyEvent.VK_S)) y++;
        if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT) || Keyboard.isKeyPressed(KeyEvent.VK_A)) x--;
        if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) || Keyboard.isKeyPressed(KeyEvent.VK_D)) x++;
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
        long lastTime = System.nanoTime();
        long time = System.currentTimeMillis();
        double partTime = 1_000_000_000 / 60.0;
        double delta = 0;

        int updates = 0;
        int frames = 0;

        while (running) {
            long timeNow = System.nanoTime();
            delta += timeNow - lastTime;
            lastTime = System.nanoTime();
            if (delta >= partTime) {
                update();
                updates++;
                delta = 0;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - time > 1000) {
                time+=1000;
                System.out.println("Updates: " + updates + ", Frames: " + frames);
                frames = 0;
                updates = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }
}

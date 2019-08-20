package com.vosure.game;

import com.vosure.game.entity.mob.Player;
import com.vosure.game.graphics.Screen;
import com.vosure.game.input.Keyboard;
import com.vosure.game.level.Level;
import com.vosure.game.level.RandomLevel;

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
    private int x = 0, y = 0;

    private Thread thread;
    private boolean running;

    private Keyboard keyboardInput;

    private Screen screen;
    private Level level;
    private Player player;

    private JFrame frame = null;
    private Graphics g = null;
    private BufferStrategy bs;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();


    public Game() {
        setPreferredSize(new Dimension(width * scale, height * scale));

        screen = new Screen(width, height, pixels);
        level = new RandomLevel(width, height);
        keyboardInput = new Keyboard();
        player = new Player(keyboardInput);

        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("No Game No Life");
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.requestFocus();

        addKeyListener(new Keyboard());

        createBufferStrategy(3);
        bs = getBufferStrategy();
    }

    private void render() {
        g = bs.getDrawGraphics();

        screen.clear();

        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;

        level.render(xScroll, yScroll, screen);
        player.render(screen);

        for (int i = 0 ; i< pixels.length;i++)
            pixels[i] = screen.pixels[i];

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }

    private void update() {
        if (keyboardInput.escape){
            frame.dispose();
            thread.stop();
        }
        keyboardInput.update();
        player.update();

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
                time += 1000;
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

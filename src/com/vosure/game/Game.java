package com.vosure.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    private Thread thread;
    private boolean running;
    private JFrame frame;

    public Game(){
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("No Game No Life");
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
    }

    public void update(){

    }

    public synchronized void start(){
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized  void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running){
            update();
            render();
        }
    }

    public static void main(String[] args){
        Game game = new Game();
        game.start();
    }

}

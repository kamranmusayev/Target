package com.target.basegame;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JLabel;


import com.target.objects.Map;
import com.target.windows.Window;

public class Main extends JLabel implements Runnable{
	private static final long serialVersionUID = -142570772786901434L;
	public static int WIDTH = 900,HEIGHT = WIDTH/16*9;
	public String title;
	public Thread thread;
	public boolean running;
	public Handler handler;
	public Map map;
	public DefaultUser user;
	public int currentLevel;
	public int delay_to_close = 3;
	public Window window;
	public static boolean flag1 = true;
	//Initialize the variables
	public Main(String title) throws IOException {
		//System.setProperty("awt.dnd.drag.threshold", "10");
		this.title = title;
		currentLevel=1;
		running = false;
		handler = new Handler();
		thread = new Thread(this);
		user = new DefaultUser();
		try {
			map = new Map(handler,user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error while creating map");
			e.printStackTrace();
		}
		window = new Window(title,this, user);
	}
	
	// Method to restrict the variable between min and max values
	public static int clamp(int var, int min, int max){
	    if(var>=max)
	        return var=max;
	    else if(var<=min)
	        return var=min;
	    else
	        return var;
	}
	
	//Create the Thread
	public synchronized void start() {
		running=true;
		if(thread.getState() == Thread.State.NEW) {
			thread.start(); // Automatically runs the run method in the Main Class
			//System.out.println(thread.getState());
		}
		else {
			map.initilizer();
			thread = new Thread(this);
			thread.start();
		}
	}
	
	//Destroy the Thread
	public synchronized void stop() {
		running = false;
		thread.interrupt();
	}
	
	// Update all the objects
	public void update() {
		map.update();
	}
	
	//Paint all the objects
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		map.render(g);
	}
	
	// Main loop 
	@Override
	public void run() {
		long lastTime = System.nanoTime(); // Current Time in nanoseconds
        double amountOfTicks = 60.0; // Setting Frames per second(FPS)
        double ns = 1000000000 / amountOfTicks; // Calculating how many nanosecond should pass in order to achieve 60 FPS
        double delta = 0;
        long timer = System.currentTimeMillis(); // Current Time in milliseconds
       // int frames = 0 ;
        while (running) {
            long now = System.nanoTime(); // Current Time in nanoseconds
            delta += (now - lastTime) / ns; // Calculate the difference between amount of time passed and compare it to ns
            lastTime = now; 
            while (delta >= 1) { // if the the ratio is more than 1 then the time is elapsed in order to achieve 60 FPS
               if(map.getRunningState())
            	   update(); // Update all the frames
                delta--; // Decrease the delta in order to restart FPS count down
            }
            if(running)
                repaint(); // Repaint in each loop
            //frames++;
            if(System.currentTimeMillis() - timer > 1000) { // Check if the current time and timer difference is 1000 millisecond
                timer += 1000; // Add 1000 millisecond (1 second) to the timer
                try {
					map.deplete_Time();
				} catch (Exception e) {
					e.printStackTrace();
				}
                if(map.get_gameState() == 1 || map.get_gameState() == -1) delay_to_close--;
                if(delay_to_close == 0) {
					try {
						 
						delay_to_close = 3;
						map.initilizer();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
                }
                if(map.getLevel()>5) {
                	running = false;
                	try {
                		map.setLevel(5);
						Map.setstaticLevel(5);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                //System.out.println("Time left: "+map.getTime());
               // System.out.println("FPS: " + frames); // Print the achieved max FPS
              //  frames = 0; // Reset the FPS counter
            }
        }
      
        stop(); // Destroy the thread
        flag1 = false;
        window.createmainmenu();
        delay_to_close = 3;
	}
	
	public static void main(String[] args) {
		try {
			new Main("Target_v0.01alpha");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

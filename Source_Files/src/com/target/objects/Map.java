package com.target.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.target.basegame.DefaultUser;
import com.target.basegame.Handler;
import com.target.basegame.Main;

public class Map implements Visual{
	
	private Image backgroundImage;
	private static int level; // According to level images will change
	private Handler handler;
	private int countdown_time;
	private int initial_time;
	private int gameState;//0 - running / 1 - win / -1 - lose / 2 stop
	private DefaultUser user;
	public Map(Handler handler,DefaultUser user) throws Exception {
		this.user =user;
		this.setHandler(handler);
		level = 1;
		setLevel(level);
		set_gameState(0);
		setTime(50);
	}
	
/*
 * 
 *      Image username_image = ImageIO.read(getClass().getResource(Images.USERNAME.getString()));
        username_image = username_image.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
 * 
 * */
	public void setLevel(int init_level) throws Exception {
		Image image=null;
		if(init_level == 1) {//Initilize level 1
			try {
				handler.clean();
				backgroundImage = ImageIO.read(getClass().getResource(Images.MAP1.getString()));
				backgroundImage = backgroundImage.getScaledInstance(Main.WIDTH, Main.HEIGHT-35, Image.SCALE_DEFAULT);
				//map1.jpg
				
				image = ImageIO.read(getClass().getResource(Images.ARROW1.getString()));
				image = image.getScaledInstance(100, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Arrow(90,385,100,30,0,0,"Basic",image,handler));
				
				image = ImageIO.read(getClass().getResource(Images.BOW1.getString()));
				image = image.getScaledInstance(50, 100, Image.SCALE_DEFAULT);
				
				handler.addObject( new Bow(100,350,50,100,0,0,"Basic",image));
	
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE1.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				
				handler.addObject(new Obstacle(550,300,40,120,40,120,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE1.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(810,320,10,100,10,100,null,image));
				
				
				image = ImageIO.read(getClass().getResource(Images.GOAL1.getString()));
				image = image.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Goal(800,300,30,30,30,30,null,image));
				
				setTime(50);
				setInitTime(50);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		
		}
		else if(init_level == 2) {//Initialize level 2
			try {
				handler.clean();
				backgroundImage = ImageIO.read(getClass().getResource(Images.MAP1.getString()));
				backgroundImage = backgroundImage.getScaledInstance(Main.WIDTH, Main.HEIGHT-35, Image.SCALE_DEFAULT);
				//map1.jpg
				
				image = ImageIO.read(getClass().getResource(Images.ARROW1.getString()));
				image = image.getScaledInstance(100, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Arrow(90,385,100,30,0,0,"Basic",image,handler));
				
				image = ImageIO.read(getClass().getResource(Images.BOW1.getString()));
				image = image.getScaledInstance(50, 100, Image.SCALE_DEFAULT);
				handler.addObject( new Bow(100,350,50,100,0,0,"Basic",image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE1.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				
				handler.addObject(new Obstacle(550,330,40,120,40,120,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE2.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(320,350,140,100,140,100,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE6.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(415,325,40,50,40,50,null,image));
					
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE1.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(810,320,10,100,10,100,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.GOAL1.getString()));
				image = image.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Goal(800,300,30,30,30,30,null,image));
				setTime(40);
				setInitTime(40);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		else if(init_level == 3) {//Initialize level 3
			try {
				handler.clean();
				backgroundImage = ImageIO.read(getClass().getResource(Images.MAP2.getString()));
				backgroundImage = backgroundImage.getScaledInstance(Main.WIDTH, Main.HEIGHT-35, Image.SCALE_DEFAULT);
				//map1.jpg
				
				image = ImageIO.read(getClass().getResource(Images.ARROW1.getString()));
				image = image.getScaledInstance(100, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Arrow(90,385,100,30,0,0,"Basic",image,handler));
				
				image = ImageIO.read(getClass().getResource(Images.BOW1.getString()));
				image = image.getScaledInstance(50, 100, Image.SCALE_DEFAULT);
				handler.addObject( new Bow(100,350,50,100,0,0,"Basic",image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE6.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject( new Obstacle(260,330,80,80,80,80,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE1.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(660,175,10,250,10,250,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE1.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(550,0,25,150,25,150,null,image));
				
				
				image = ImageIO.read(getClass().getResource(Images.GOAL1.getString()));
				image = image.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Goal(650,150,30,30,30,30,null,image));
				
				
				
				setTime(30);
				setInitTime(30);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(init_level == 4) {//Initialize  level 4
			try {
				handler.clean();
				backgroundImage = ImageIO.read(getClass().getResource(Images.MAP2.getString()));
				backgroundImage = backgroundImage.getScaledInstance(Main.WIDTH, Main.HEIGHT-35, Image.SCALE_DEFAULT);
				//map1.jpg
				
				image = ImageIO.read(getClass().getResource(Images.ARROW1.getString()));
				image = image.getScaledInstance(100, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Arrow(90,385,100,30,0,0,"Basic",image,handler));
				
				image = ImageIO.read(getClass().getResource(Images.BOW1.getString()));
				image = image.getScaledInstance(50, 100, Image.SCALE_DEFAULT);
				handler.addObject( new Bow(100,350,50,100,0,0,"Basic",image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE4.getString()));
				image = image.getScaledInstance(100, 300, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(270,350,100,70,90,50,null,image));
				
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE5.getString()));
				image = image.getScaledInstance(40, 250, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(380,280,120,150,100,100,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE1.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(810,320,10,100,10,100,null,image));
				
				
				image = ImageIO.read(getClass().getResource(Images.GOAL1.getString()));
				image = image.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Goal(800,300,30,30,30,30,null,image));
				
				
				setTime(20);
				setInitTime(20);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else if(init_level == 5) {//Initialize level 5
			try {
				handler.clean();
				backgroundImage = ImageIO.read(getClass().getResource(Images.MAP4.getString()));
				backgroundImage = backgroundImage.getScaledInstance(Main.WIDTH, Main.HEIGHT-35, Image.SCALE_DEFAULT);
				//map1.jpg
				
				image = ImageIO.read(getClass().getResource(Images.ARROW1.getString()));
				image = image.getScaledInstance(100, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Arrow(90,385,100,30,0,0,"Basic",image,handler));
				
				image = ImageIO.read(getClass().getResource(Images.BOW1.getString()));
				image = image.getScaledInstance(50, 100, Image.SCALE_DEFAULT);
				handler.addObject( new Bow(100,350,50,100,0,0,"Basic",image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE3.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(250,350,150,100,150,100,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE3.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(500,240,220,200,220,200,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE3.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(400,240,100,200,100,180,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.OBSTACLE1.getString()));
				image = image.getScaledInstance(40, 150, Image.SCALE_DEFAULT);
				handler.addObject(new Obstacle(810,210,10,230,10,230,null,image));
				
				image = ImageIO.read(getClass().getResource(Images.GOAL1.getString()));
				image = image.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
				handler.addObject(new Goal(800,200,30,30,30,30,null,image));
			
				
				setTime(15);
				setInitTime(15);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
			throw new Exception("Unrecognized level!");
		
		
	}
	
	@Override
	public void update() {
		//? Create each Map Level
		if(handler.Collision == 1)
			try {
				set_gameState(1);
				level++;
				user.increaseUserscore( getTime()*1000/getInitTime());//Increase user score by 0-1000 depending on the time left
	        	if((getTime()) >= getInitTime()*2/3 ) user.increaseCurrency(100);
	        	else if(getTime() >= getInitTime()*1/3) user.increaseCurrency(50);
	        	else user.increaseCurrency(25);
				level = Main.clamp(level, 1, 6);
				if(level != 6) {
					setLevel(level);
				} else {
					setLevel(5);
				}
				if(level > user.getCurrentlevel())
					user.setCurrentlevel(level);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(getTime() > 0 && get_gameState() == 0)
			handler.update();	
	
	}
	
	@Override
	public void render(Graphics g) {
		if(get_gameState() == 0) {
			g.drawImage(backgroundImage,0,0,null);// Draw backgroundImage
			g.setColor(Color.ORANGE);
			g.setFont(new Font("Algerian", Font.BOLD, 30));
			g.drawString("Time: "+getTime(), 370, 50);
			g.drawString("Score: "+user.getUserscore(), 50, 50);
			
		}
		else if(get_gameState() == 1) {
			g.drawImage(backgroundImage,0,0,null); //Winscreen
			g.setColor(Color.ORANGE);
			g.setFont(new Font("Algerian", Font.BOLD, 30));
			g.drawString("Time: "+ getTime(), 370, 50);
			g.drawString("Score: "+user.getUserscore(), 50, 50);
			g.setColor(Color.GREEN);
			g.setFont(new Font("Algerian", Font.BOLD, 50));
			g.drawString("You Won", 320, 200);
		}
		else {
			g.drawImage(backgroundImage,0,0,null);//Lose screen
			g.setColor(Color.ORANGE);
			g.setFont(new Font("Algerian", Font.BOLD, 30));
			g.drawString("Time: "+getTime(), 370, 50);
			g.drawString("Score: "+user.getUserscore(), 50, 50);
			g.setColor(Color.RED);
			g.setFont(new Font("Algerian", Font.BOLD, 50));
			g.drawString("You Lost", 350,200 );
		}
		handler.render(g); // Draw the objects
	}
	
	public int getLevel() {
		return level;
	}


	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public void deplete_Time() throws Exception {
		if(getTime() > 0 && getRunningState())
			this.countdown_time -= 1; 
		if(getTime() == 0)
			set_gameState(-1);

	}
	
	
	public int getTime() {
		return this.countdown_time;
	}
	
	
	
	public void setTime(int Time) throws Exception {
		if(Time > 0)
			this.countdown_time = Time;
		else
			 throw new Exception("Invalid value for countdown_time");
		
	}
	
	

	public int get_gameState() {
		return this.gameState;
	}
	public boolean getRunningState() {//To set running state for the main thread
		if(get_gameState() == 0)
			return true;
		else 
			return false;
	}
	
	
	private void set_gameState(int state) throws Exception{
		if(state == 0 || state == 1 || state == -1 || state == 2)
			this.gameState = state;
		else
			  throw new Exception("Unexpected value for Game State");
			
	}
	private void setInitTime(int time) {
		initial_time = time; 
	}
	public int getInitTime() {
		return initial_time;
	}

	public void initilizer() {
		handler.Collision = -1;
		handler.clean();
		try {
			set_gameState(0);
			if(level<=5)
				setLevel(level);
			else
				setLevel(5);
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	public static void setstaticLevel(int level) {
		Map.level=level;
	}
	
	public static int getstaticLevel() {
		return Map.level;
	}
	@Override
	public Rectangle Boundry() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

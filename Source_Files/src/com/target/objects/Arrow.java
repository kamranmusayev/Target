package com.target.objects;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import com.target.basegame.Handler;
import com.target.basegame.Main;
import com.target.inputs.MouseInput;

public class Arrow extends Objects{
	private float velocity_x,velocity_y;
	private Handler handler;
	private int relative_pos_x;
	private int relative_pos_y;

	private boolean active;
	public Arrow(int x_pos, int y_pos, int size_x, int size_y,int width,int height,String type, Image image, Handler handler) {
		super(x_pos, y_pos, size_x, size_y, size_x,size_y,type, image);
		this.velocity_x = 7;
		this.velocity_y = 0;
		this.handler = handler;
		this.relative_pos_x = x_pos;
		this.relative_pos_y = y_pos;
		this.active = false;
		
		MouseInput.flag=false;
		
	}

	@Override
	public void update() {
		//int originalx_pos = 80;
		//System.out.println("Velocity X :" + velocity_x + "Velocity Y :" + velocity_y);
		if(x_pos > Main.WIDTH || y_pos > Main.HEIGHT) {
			x_pos = relative_pos_x;y_pos = relative_pos_y;
			rotation_angle = 0;
			velocity_y = 0;
			MouseInput.drag = false;
			MouseInput.flag=false;
			active = false;
			//MouseInput.flag = true;
			//active = false;
		}
		if(active) {arrowdrop();return;}
		if(handler.collision()==1) { // Collision with a goal
			MouseInput.flag=false;
			
		}
		
		else if(handler.collision()==0) {  // Collision with an obstacle
			if(MouseInput.flag) velocity_y = 0;
			MouseInput.flag=false;
			active = true;	
		}
		
		else {
			if(MouseInput.flag) { // If the mouse is clicked change arrow's position			 
			
				arrowpath(); //? Implement the method
			
			}
			
			else if(MouseInput.drag) {
				int x;
				if((MouseInput.static_arrow_move_y - MouseInput.len_y) > 41) {x = 41;}else if((MouseInput.static_arrow_move_y - MouseInput.len_y)< 0 ) {x = 0;} else {x = Math.abs((MouseInput.static_arrow_move_y - MouseInput.len_y));}
				double y_angle = (double) x/41;
				rotation_angle =(float) Math.atan(y_angle);
				y_pos = relative_pos_y + 41*(int)Math.toDegrees((double) rotation_angle)/45;
			}
			
			else {
				x_pos = relative_pos_x;
				y_pos = relative_pos_y;
			}
			
		}
	
	}


	@Override
	public void render(Graphics g) {
		if(rotation_angle == 0) {
			g.drawImage(image, x_pos, y_pos, size_x, size_y, null);
			
			// Draw Collision Box
			//g.setColor(Color.RED);
		
			//g.drawRect(x_pos+size_x-20,y_pos,20,20);
		}
		
		else {
			
			Graphics2D g2d = (Graphics2D)g;
			AffineTransform trans = new AffineTransform();
			trans.translate(x_pos, y_pos);
			trans.rotate(-rotation_angle);
			g2d.drawImage(image, trans, null);
			//g.setColor(Color.RED);
			
			//g.drawRect((int)(x_pos + Math.abs(Math.cos(rotation_angle)*(size_x-20))),(int)(y_pos - Math.sin(rotation_angle)*(size_x-20)),20,20);

		}
	}
	@Override
	public Rectangle boundry() { // Method for returning the boundaries of an object
		return new Rectangle((int)(x_pos + Math.abs(Math.cos(rotation_angle)*(size_x-20))),(int)(y_pos - (Math.sin(rotation_angle)*(size_x-20))),20,20);
	}
	

	public float getVelocity_y() {
		return velocity_y;
	}

	public void setVelocity_y(int velocity_y) {
		this.velocity_y = velocity_y;
	}
	
	private void arrowpath() {
		//? Calculate the path of the arrow
		if(velocity_y == 0) {//Calculate the rotation angle 
			//velocity_x = 7*MouseInput.len_x/13;
			velocity_y = 7*MouseInput.len_y/41;
		}
		rotation_angle =  (float) Math.atan(velocity_y/velocity_x) ;
		x_pos+=velocity_x;
		y_pos -= velocity_y;
		velocity_y -= 0.08; 
		
		
	}
	private void arrowdrop() {
		
		y_pos -= velocity_y;
		velocity_y -= 0.08; 
	}

	@Override
	public Rectangle Boundry() {
		return new Rectangle((int)(x_pos + Math.abs(Math.cos(rotation_angle)*(size_x-20))),(int)(y_pos - (Math.sin(rotation_angle)*(size_x-20))),20,20);
	}
}

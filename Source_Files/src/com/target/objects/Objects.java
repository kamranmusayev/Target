package com.target.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public abstract class Objects implements Visual{
	
	protected int x_pos,y_pos; // Coordinates of the object
	protected int size_x,size_y; // Size of the object
	protected String type; // Type of the object (e.g Arrow can have 4 types according to its image)
	protected Image image;
	protected float rotation_angle;
	protected int boundry_x = 0;
	protected int boundry_y = 0;
	public Objects(int x_pos, int y_pos, int size_x, int size_y,int Boundry_Width,int Boundry_Height, String type, Image image) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.size_x = size_x;
		this.size_y = size_y;
		this.type = type;
		this.image = image;
		this.rotation_angle = 0;
		this.boundry_x = Boundry_Width;
		this.boundry_y = Boundry_Height;
	}
	
	public Rectangle boundry() { // Method for returning the boundaries of an object
		if(boundry_y != size_y)
			return new Rectangle(x_pos+(size_x - boundry_x)/2,y_pos + (size_y - boundry_y+20)/2,boundry_x,boundry_y);
		else
			return new Rectangle(x_pos+(size_x - boundry_x)/2,y_pos + (size_y - boundry_y)/2,boundry_x,boundry_y);
	}
	
	@Override
	public void render(Graphics g) {
		if(rotation_angle == 0) {
			g.drawImage(image, x_pos, y_pos, size_x, size_y, null);
			
			// Draw Collision Box
			g.setColor(Color.RED);
			/*if(boundry_y != size_y)
				g.drawRect(x_pos+(size_x - boundry_x)/2,y_pos + (size_y - boundry_y+20)/2,boundry_x,boundry_y);
			else
				g.drawRect(x_pos+(size_x - boundry_x)/2,y_pos + (size_y - boundry_y)/2,boundry_x,boundry_y);*/
		}
		
		else {
			
			Graphics2D g2d = (Graphics2D)g;
			AffineTransform trans = new AffineTransform();
			trans.translate(x_pos, y_pos);
			trans.rotate(-rotation_angle);
			g2d.drawImage(image, trans, null);
			//g.setColor(Color.RED);
			//g.drawRect(x_pos, y_pos, boundry_x, boundry_y);

		}
	}
	
	public int getX_pos() {
		return x_pos;
	}

	public void setX_pos(int x_pos) {
		this.x_pos = x_pos;
	}

	public int getY_pos() {
		return y_pos;
	}

	public void setY_pos(int y_pos) {
		this.y_pos = y_pos;
	}

	public int getSize_x() {
		return size_x;
	}

	public void setSize_x(int size_x) {
		this.size_x = size_x;
	}

	public int getSize_y() {
		return size_y;
	}

	public void setSize_y(int size_y) {
		this.size_y = size_y;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}

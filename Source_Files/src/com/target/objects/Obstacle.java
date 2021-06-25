package com.target.objects;

import java.awt.Image;
import java.awt.Rectangle;

public class Obstacle extends Objects {
	public Obstacle(int x_pos, int y_pos, int size_x, int size_y, int width,int height,String type, Image image) {
		super(x_pos, y_pos, size_x, size_y,width,height, type, image);
	}

	@Override
	public void update() {
		//? Code
		
	}



	@Override
	public Rectangle Boundry() {
		return boundry();
	}	
}

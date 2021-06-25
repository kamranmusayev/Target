package com.target.objects;

import java.awt.Image;
import java.awt.Rectangle;

public class Goal extends Objects{
	
	public Goal(int x_pos, int y_pos, int size_x, int size_y, int Width,int Height,String type, Image image) {
		super(x_pos, y_pos, size_x, size_y,Width,Height, type, image);
	}

	@Override
	public void update() {
		//? Code
		
	}



	@Override
	public Rectangle Boundry() {
		return new Rectangle(x_pos,y_pos,size_x,size_y);
	}

}

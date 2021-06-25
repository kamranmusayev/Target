package com.target.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.target.inputs.MouseInput;


public class Bow extends Objects {
	private int relative_pos_y ;
	private int relative_pos_x ;
	public Bow(int x_pos, int y_pos, int size_x, int size_y, int Width,int Height,String type, Image image) {
		super(x_pos, y_pos, size_x, size_y, size_x,size_y,type, image);
		relative_pos_y = y_pos;
		relative_pos_x = x_pos;
	}

	@Override
	public void update() {
		if(MouseInput.drag)
			rotateBow();
		if(MouseInput.flag) 
		{
			rotation_angle = 0;
			x_pos = relative_pos_x;
			y_pos = relative_pos_y;
		}
			
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
	}
	
	public void rotateBow() {
			int x;
			if((MouseInput.static_arrow_move_y - MouseInput.len_y) > 41) {x = 41;}else if((MouseInput.static_arrow_move_y - MouseInput.len_y)< 0 ) {x = 0;} else {x = Math.abs((MouseInput.static_arrow_move_y - MouseInput.len_y));}
			double y_angle = (double) x/41;
			rotation_angle =(float) Math.atan(y_angle);
			y_pos = relative_pos_y + 38*(int)Math.toDegrees((double) rotation_angle)/45;
			x_pos = relative_pos_x - 17*(int)Math.toDegrees((double) rotation_angle)/45;
		}


	@Override
	public Rectangle Boundry() {
		return boundry();
	}
	}

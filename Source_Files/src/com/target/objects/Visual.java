package com.target.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Visual {
	
	public void update(); // Method for updating the variables if needs be
	public void render(Graphics g); // Method in order to render the objects
	public Rectangle Boundry();
	
}

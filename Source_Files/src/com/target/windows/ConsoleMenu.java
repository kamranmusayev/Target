package com.target.windows;

import java.awt.Graphics;

import com.target.basegame.DefaultUser;

public class ConsoleMenu extends Menu{

	private static final long serialVersionUID = 6667208349588861919L;

	ConsoleMenu(Window window,DefaultUser user) {
		super(window,user);
		//? Code
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//g.drawImage(image,0,0,null); // Draw the background Image
	}
	
}

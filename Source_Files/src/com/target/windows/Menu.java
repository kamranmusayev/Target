package com.target.windows;

import java.awt.Image;

import javax.swing.JLayeredPane;

import com.target.basegame.DefaultUser;

public abstract class Menu extends JLayeredPane{
	
	private static final long serialVersionUID = 732390242660880126L;
	protected Image image;
	protected Window window;
	protected DefaultUser user;
	Menu(Window window, DefaultUser user){
		this.window=window;
		this.user = user;
	}
}

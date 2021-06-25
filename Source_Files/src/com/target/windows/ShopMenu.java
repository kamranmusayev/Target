package com.target.windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.target.basegame.DefaultUser;
import com.target.basegame.Main;
import com.target.objects.Images;

public class ShopMenu extends Menu{

	private static final long serialVersionUID = 6667208349588861919L;

	@SuppressWarnings("deprecation")
	ShopMenu(Window window,DefaultUser user) {
		super(window,user);
		try {
			//image = ImageIO.read(new File(Images.SHOPMENU.getString())).getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
			image = ImageIO.read(getClass().getResource(Images.SHOPMENU.getString()));
			image = image.getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 5TL butonu
		JButton TL5 = new JButton();
		TL5.setOpaque(false); // Set button corners to be transparent
		TL5.setContentAreaFilled(false); // Set button to be transparent
		TL5.setBorderPainted(false); // Remove borders
		TL5.setBounds(60, 110, 120, 40); // Set button location
		TL5.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		TL5.setActionCommand("TL1"); // Set action command for the ActionListener
		TL5.addActionListener(window); 
		
	    this.add(TL5, new Integer(3)); // Add the button to the Pane
	    
	    // 10TL butonu
	 	JButton TL10 = new JButton();
	 	TL10.setOpaque(false); // Set button corners to be transparent
	 	TL10.setContentAreaFilled(false); // Set button to be transparent
	 	TL10.setBorderPainted(false); // Remove borders
	 	TL10.setBounds(260, 110, 120, 40); // Set button location
	 	TL10.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	TL10.setActionCommand("TL2"); // Set action command for the ActionListener
	 	TL10.addActionListener(window); 
	 	
	 	this.add(TL10, new Integer(3)); // Add the button to the Pane
	 	
	 	// 20TL butonu
	 	JButton TL20 = new JButton();
	 	TL20.setOpaque(false); // Set button corners to be transparent
	 	TL20.setContentAreaFilled(false); // Set button to be transparent
	 	TL20.setBorderPainted(false); // Remove borders
	 	TL20.setBounds(455, 110, 120, 40); // Set button location
	  	TL20.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	TL20.setActionCommand("TL3"); // Set action command for the ActionListener
	 	TL20.addActionListener(window); 
	 	
	 	this.add(TL20, new Integer(3)); // Add the button to the Pane
	 	
	 	// 30TL butonu
	 	JButton TL30 = new JButton();
	 	TL30.setOpaque(false); // Set button corners to be transparent
	 	TL30.setContentAreaFilled(false); // Set button to be transparent
	 	TL30.setBorderPainted(false); // Remove borders
	 	TL30.setBounds(645, 110, 120, 40); // Set button location
	 	TL30.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	TL30.setActionCommand("TL4"); // Set action command for the ActionListener
		TL30.addActionListener(window); 
		
	    this.add(TL30, new Integer(3)); // Add the button to the Pane

	    // quit butonu
	 	JButton quit = new JButton();
	 	quit.setOpaque(false); // Set button corners to be transparent
	 	quit.setContentAreaFilled(false); // Set button to be transparent
	 	quit.setBorderPainted(false); // Remove borders
	 	quit.setBounds(25, 5, 60, 60); // Set button location
	 	quit.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	quit.setActionCommand("back"); // Set action command for the ActionListener
	 	quit.addActionListener(window); 
	 
	    this.add(quit, new Integer(3)); // Add the button to the Pane
	    
	    
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,null); // Draw the background Image
	}
	
}


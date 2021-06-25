package com.target.windows;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.target.basegame.DefaultUser;
import com.target.basegame.Main;
import com.target.objects.Images;
import com.target.objects.Map;

public class LevelMenu extends Menu{

	private static final long serialVersionUID = 6667208349588861919L;

	@SuppressWarnings("deprecation")
	LevelMenu(Window window,DefaultUser user) {
		super(window, user);
		try {
			//image = ImageIO.read(new File(Images.LEVELMENU.getString())).getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
			image = ImageIO.read(getClass().getResource(Images.LEVELMENU.getString()));
			image = image.getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JButton level1 = new JButton();
		level1.setOpaque(false); // Set button corners to be transparent
		level1.setContentAreaFilled(false); // Set button to be transparent
		level1.setBorderPainted(false); // Remove borders
		level1.setBounds(50, 70, 160, 60); // Set button location
		level1.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		level1.setActionCommand("level1"); // Set action command for the ActionListener
		level1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.getContentPane().removeAll(); // Remove all the content from the frame for a fresh start
				try {
					Map.setstaticLevel(1);
					window.game.map.setLevel(1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    window.add(window.game); 
				window.setVisible(true);
				window.game.start(); // Start the game 
				
			}
			
		}); 
		
	    this.add(level1, new Integer(3)); // Add the button to the Pane
	    
	    JButton level2 = new JButton();
		level2.setOpaque(false); // Set button corners to be transparent
		level2.setContentAreaFilled(false); // Set button to be transparent
		level2.setBorderPainted(false); // Remove borders
		level2.setBounds(260, 70, 160, 60); // Set button location
		level2.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		level2.setActionCommand("level2"); // Set action command for the ActionListener
		level2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.getCurrentlevel()>=2) {
					window.getContentPane().removeAll(); // Remove all the content from the frame for a fresh start
					try {
						Map.setstaticLevel(2);
						window.game.map.setLevel(2);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					window.add(window.game); 
					window.setVisible(true);
					window.game.start(); // Start the game 
				} else {
					JOptionPane.showMessageDialog(null,"Unlock level " + user.getCurrentlevel() + " before playing 2" );
				}
				
			}
			
		}); 
		
	    this.add(level2, new Integer(3)); // Add the button to the Pane
	    
	    JButton level3 = new JButton();
		level3.setOpaque(false); // Set button corners to be transparent
		level3.setContentAreaFilled(false); // Set button to be transparent
		level3.setBorderPainted(false); // Remove borders
		level3.setBounds(470, 70, 160, 60); // Set button location
		level3.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		level3.setActionCommand("level3"); // Set action command for the ActionListener
		level3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.getCurrentlevel()>=3) {
					window.getContentPane().removeAll(); // Remove all the content from the frame for a fresh start
					try {
						Map.setstaticLevel(3);
						window.game.map.setLevel(3);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					window.add(window.game); 
					window.setVisible(true);
					window.game.start(); // Start the game 
				} else {
					JOptionPane.showMessageDialog(null,"Unlock level " + user.getCurrentlevel() + " before playing level 3");
				}
				
			}
			
		}); 
		
	    this.add(level3, new Integer(3)); // Add the button to the Pane
	    
	    JButton level4 = new JButton();
		level4.setOpaque(false); // Set button corners to be transparent
		level4.setContentAreaFilled(false); // Set button to be transparent
		level4.setBorderPainted(false); // Remove borders
		level4.setBounds(685, 70, 160, 60); // Set button location
		level4.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		level4.setActionCommand("level4"); // Set action command for the ActionListener
		level4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.getCurrentlevel()>=4) {
					window.getContentPane().removeAll(); // Remove all the content from the frame for a fresh start
					try {
						Map.setstaticLevel(4);
						window.game.map.setLevel(4);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					window.add(window.game); 
					window.setVisible(true);
					window.game.start(); // Start the game 
				} else {
					JOptionPane.showMessageDialog(null,"Unlock level " + user.getCurrentlevel() + " before playing level 4");
				}
				
			}
			
		}); 
		
	    this.add(level4, new Integer(3)); // Add the button to the Pane
	    
	    JButton level5 = new JButton();
		level5.setOpaque(false); // Set button corners to be transparent
		level5.setContentAreaFilled(false); // Set button to be transparent
		level5.setBorderPainted(false); // Remove borders
		level5.setBounds(50, 200, 160, 60); // Set button location
		level5.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		level5.setActionCommand("level5"); // Set action command for the ActionListener
		level5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.getCurrentlevel()>=3) {
					window.getContentPane().removeAll(); // Remove all the content from the frame for a fresh start
					try {
						Map.setstaticLevel(5);
						window.game.map.setLevel(5);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					window.add(window.game); 
					window.setVisible(true);
					window.game.start(); // Start the game 
				} else {
					JOptionPane.showMessageDialog(null,"Unlock level " + user.getCurrentlevel() + " before playing level 5");
				}
				
			}
			
		});  
		
	    this.add(level5, new Integer(3)); // Add the button to the Pane
	    
	    JButton quit = new JButton();
	    quit.setOpaque(false); // Set button corners to be transparent
	    quit.setContentAreaFilled(false); // Set button to be transparent
	    quit.setBorderPainted(false); // Remove borders
	    quit.setBounds(10, 0, 80, 60); // Set button location
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

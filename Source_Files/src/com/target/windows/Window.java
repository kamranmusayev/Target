package com.target.windows;


import java.awt.Color;

import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import com.target.basegame.DefaultUser;
import com.target.basegame.Main;
import com.target.inputs.KeyInput;
import com.target.inputs.MouseInput;
import com.target.objects.Images;

public class Window extends JFrame implements ActionListener{
	private static final long serialVersionUID = 8759903506538754024L;
	public Main game;
	public Image image;
	public Menu menu;
	public DefaultUser user;
	public boolean flag = false;
	public Window(String title, Main game, DefaultUser user) throws IOException {
		this.game=game;
		this.user=user;
		setTitle(title); // Set title
		setMaximumSize(new Dimension(Main.WIDTH,Main.HEIGHT)); // Set maximum size of the frame 
		setMinimumSize(new Dimension(Main.WIDTH,Main.HEIGHT)); // Set minimum size of the frame
		setResizable(false); // Set resizable to false for now ( Will be changed when the dynamic resolution change will be implemented )
		setLocationRelativeTo(null); // Set it to appear in the middle of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close when X button is pressed
		addWindowListener(new WindowAdapter() {
		     @Override
		     public void windowClosing(WindowEvent arg0) {
		    	 	if(flag)
		    	 		user.writeSave(user.getLogin(),user.getPassword()); 
		         	System.exit(0);
		     }
		});
		if(Main.flag1) {
			addKeyListener(new KeyInput()); // Add a KeyListener
	    	addMouseListener(new MouseInput()); // Add a MouseListener for mouseClicked and so on
	    	addMouseMotionListener(new MouseInput()); // Add MouseMotionListener for mouseDragged and so on
		}
		//Image image = ImageIO.read(new File(Images.BACKGROUND.getString())).getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
		image = ImageIO.read(getClass().getResource(Images.BACKGROUND.getString()));
		image = image.getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
		// Set the Login Screen
		JLayeredPane pane = new JLayeredPane(){
			private static final long serialVersionUID = -6954995909346195595L;

			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(image,0,0,null);
			}
		};
		// Create Username label and textfield
		JLabel username = new JLabel("Username: ");
		username.setBounds(100, 100, 100, 100);
		//Image username_image = ImageIO.read(new File(Images.USERNAME.getString())).getScaledInstance(100, 50, Image.SCALE_DEFAULT);
		Image username_image = ImageIO.read(getClass().getResource(Images.USERNAME.getString()));
		username_image = username_image.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(username_image);
		username.setIcon(icon);
		username.setForeground(Color.WHITE);
		
		JTextField username_text = new JTextField();
		username_text.setBounds(240, 143, 120, 18);
		
		// Create Password label and passwordfield
		JLabel password = new JLabel("Password: ");
		password.setBounds(100, 155, 100, 100);
		//Image password_image = ImageIO.read(new File(Images.PASSWORD.getString())).getScaledInstance(95, 40, Image.SCALE_DEFAULT);
		Image password_image = ImageIO.read(getClass().getResource(Images.PASSWORD.getString()));
		password_image = password_image.getScaledInstance(95, 40, Image.SCALE_DEFAULT);
		icon = new ImageIcon(password_image);
		password.setIcon(icon);
		
		JPasswordField password_text = new JPasswordField();
		password_text.setBounds(240, 188, 120, 18);
		
		
		// Create Login Button
		JButton login = new JButton("Login");
		login.setBounds(330, 250, 100, 30);
		//Image login_image = ImageIO.read(new File(Images.LOGIN.getString())).getScaledInstance(95, 40, Image.SCALE_DEFAULT);
		Image login_image = ImageIO.read(getClass().getResource(Images.LOGIN.getString()));
		login_image = login_image.getScaledInstance(95, 40, Image.SCALE_DEFAULT);
		icon = new ImageIcon(login_image);
		login.setIcon(icon);
		login.setOpaque(false); 
		login.setContentAreaFilled(false); 
		login.setBorderPainted(false);
		login.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = new String( password_text.getPassword());
				if(user.readSave(username_text.getText(),str)) {
					flag= true;
					createmainmenu();
				}
				else {
					JOptionPane.showMessageDialog(null, "Login Unsuccessful! User does not exits!");
				}
			}
			
		});
		
		// Create Register Button
		JButton register = new JButton("Register");
		register.setBounds(230, 252, 100, 30);
		//Image register_image = ImageIO.read(new File(Images.REGISTER.getString())).getScaledInstance(100, 50, Image.SCALE_DEFAULT);
		Image register_image = ImageIO.read(getClass().getResource(Images.REGISTER.getString()));
		register_image = register_image.getScaledInstance(100, 50, Image.SCALE_DEFAULT);
		icon = new ImageIcon(register_image);
		register.setIcon(icon);
		register.setOpaque(false); 
		register.setContentAreaFilled(false); 
		register.setBorderPainted(false);
		register.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = new String( password_text.getPassword());
				if(user.register(username_text.getText(),str)) {
					JOptionPane.showMessageDialog(null, "Registration Successful!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Registration Unsuccessful! User already exits!");
				}
			}
			
		});
		
		
		
		// Add all the buttons , labels and texts to the pane
		pane.add(username);
		pane.add(username_text);
		pane.add(password);
		pane.add(password_text);
		pane.add(login);
		pane.add(register);
		
		//Add pane to the frame
		add(pane);
		setVisible(true); // Set visible to true
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		// Start the game if OYNA button is clicked
		if(command.equals("play")) {
			getContentPane().removeAll(); // Remove all the content from the frame for a fresh start
		    add(game); 
			setVisible(true);
			game.start(); // Start the game 
		} else if(command.equals("levels")) {
			getContentPane().removeAll(); // Remove all the content from the frame for a fresh start	
		    menu = new LevelMenu(this,user);
		    add(menu); 
			setVisible(true);
			
		} else if(command.equals("back")){
			createmainmenu();
		} else if(command.equals("shop")) {
			getContentPane().removeAll(); // Remove all the content from the frame for a fresh start
		    menu = new ShopMenu(this,user);
		    add(menu); 
			setVisible(true);
		} else if(command.equals("dress")) {
			getContentPane().removeAll(); // Remove all the content from the frame for a fresh start
		    menu = new CostumeMenu(this,user);
		    add(menu); 
			setVisible(true);
		}
		// for each command polymorphically change the menu
		//? Code
	}
	
	public void createmainmenu() {
		getContentPane().removeAll();
		menu = new MainMenu(this,user); // Initialize the MainMenu
	    add(menu);
	    setVisible(true);
	}
	
	
}

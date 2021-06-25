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

public class CostumeMenu extends Menu{

	private static final long serialVersionUID = 6667208349588861919L;

	@SuppressWarnings("deprecation")
	CostumeMenu(Window window,DefaultUser user) {
		super(window,user);
		try {
			//image = ImageIO.read(new File(Images.COSTUMEMENU1.getString())).getScaledInstance(Main.WIDTH-7, Main.HEIGHT-20, Image.SCALE_DEFAULT);
			image = ImageIO.read(getClass().getResource(Images.COSTUMEMENU1.getString()));
			image = image.getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//geri ok menu
		JButton geriOk = new JButton();
		geriOk.setOpaque(false); // Set button corners to be transparent
		geriOk.setContentAreaFilled(false); // Set button to be transparent
		geriOk.setBorderPainted(false); // Remove borders
	 	geriOk.setBounds(3, 77, 40, 40); // Set button location
	 	geriOk.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	geriOk.setActionCommand("geriOkMenu1"); // Set action command for the ActionListener
	 	geriOk.addActionListener(window); 
	 	
	    this.add(geriOk, new Integer(3)); // Add the button to the P
	    
		// ok1 butonu
		JButton ok1 = new JButton();
		ok1.setOpaque(false); // Set button corners to be transparent
		ok1.setContentAreaFilled(false); // Set button to be transparent
		ok1.setBorderPainted(false); // Remove borders
		ok1.setBounds(77, 67, 120, 73); // Set button location
		ok1.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		ok1.setActionCommand("ok1"); // Set action command for the ActionListener
		ok1.addActionListener(window); 
		
	    this.add(ok1, new Integer(3)); // Add the button to the Pane
	    
	    // ok2 butonu
	 	JButton ok2 = new JButton();
	 	ok2.setOpaque(false); // Set button corners to be transparent
	 	ok2.setContentAreaFilled(false); // Set button to be transparent
	 	ok2.setBorderPainted(false); // Remove borders
	 	ok2.setBounds(282, 67, 120, 73); // Set button location
	 	ok2.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	ok2.setActionCommand("ok2"); // Set action command for the ActionListener
	 	ok2.addActionListener(window); 
	 	
	 	this.add(ok2, new Integer(3)); // Add the button to the Pane
	 	
	 	// ok3 butonu
	 	JButton ok3 = new JButton();
	 	ok3.setOpaque(false); // Set button corners to be transparent
	 	ok3.setContentAreaFilled(false); // Set button to be transparent
	 	ok3.setBorderPainted(false); // Remove borders
	 	ok3.setBounds(486, 67, 120, 73); // Set button location
	 	ok3.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	ok3.setActionCommand("ok3"); // Set action command for the ActionListener
	 	ok3.addActionListener(window); 
	 	
	 	this.add(ok3, new Integer(3)); // Add the button to the Pane
	 	
	 	// ok4 butonu
	 	JButton ok4 = new JButton();
	 	ok4.setOpaque(false); // Set button corners to be transparent
	 	ok4.setContentAreaFilled(false); // Set button to be transparent
	 	ok4.setBorderPainted(false); // Remove borders
	 	ok4.setBounds(690, 67, 120, 73); // Set button location
	 	ok4.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	ok4.setActionCommand("ok4"); // Set action command for the ActionListener
	 	ok4.addActionListener(window); 
	 
	    this.add(ok4, new Integer(3)); // Add the button to the Pane

	    // ok ileri menü1 butonu
	 	JButton ileri = new JButton();
	 	ileri.setOpaque(false); // Set button corners to be transparent
	 	ileri.setContentAreaFilled(false); // Set button to be transparent
	 	ileri.setBorderPainted(false); // Remove borders
	 	ileri.setBounds(853, 77, 40, 40); // Set button location
	 	ileri.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	ileri.setActionCommand("ileriOkMenu1"); // Set action command for the ActionListener
	 	ileri.addActionListener(window); 
	 
	    this.add(ileri, new Integer(3)); // Add the button to the Pane

	    //geri yay butonu
	    JButton geriYay = new JButton();
	    geriYay.setOpaque(false); // Set button corners to be transparent
	    geriYay.setContentAreaFilled(false); // Set button to be transparent
	    geriYay.setBorderPainted(false); // Remove borders
	    geriYay.setBounds(3, 235, 40, 40); // Set button location
	    geriYay.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	    geriYay.setActionCommand("geriYayMenu1"); // Set action command for the ActionListener
	    geriYay.addActionListener(window); 
	   
	 	this.add(geriYay, new Integer(3)); // Add the button to the Pane
	 	
	    // yay1 butonu
	 	JButton yay1 = new JButton();
	 	yay1.setOpaque(false); // Set button corners to be transparent
	 	yay1.setContentAreaFilled(false); // Set button to be transparent
	 	yay1.setBorderPainted(false); // Remove borders
	 	yay1.setBounds(78, 218, 120, 73); // Set button location
	 	yay1.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	yay1.setActionCommand("yay1Menu1"); // Set action command for the ActionListener
	 	yay1.addActionListener(window); 
	 
	 	this.add(yay1, new Integer(3)); // Add the button to the Pane
	 	    
	 	// yay2 butonu
	 	JButton yay2 = new JButton();
	 	yay2.setOpaque(false); // Set button corners to be transparent
	 	yay2.setContentAreaFilled(false); // Set button to be transparent
	 	yay2.setBorderPainted(false); // Remove borders
	 	yay2.setBounds(283, 218, 120, 73); // Set button location
	 	yay2.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	yay2.setActionCommand("yay2Menu1"); // Set action command for the ActionListener
	 	yay2.addActionListener(window); 
	 	
	    this.add(yay2, new Integer(3)); // Add the button to the Pane
	 	    
	 	// yay3 butonu
	    JButton yay3 = new JButton();
	    yay3.setOpaque(false); // Set button corners to be transparent
	    yay3.setContentAreaFilled(false); // Set button to be transparent
	    yay3.setBorderPainted(false); // Remove borders
	    yay3.setBounds(485, 218, 120, 73); // Set button location
	    yay3.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	    yay3.setActionCommand("yay3Menu1"); // Set action command for the ActionListener
	    yay3.addActionListener(window); 
	    
	    this.add(yay3, new Integer(3)); // Add the button to the Pane
	    
	    // yay4 butonu
	    JButton yay4 = new JButton();
	 	yay4.setOpaque(false); // Set button corners to be transparent
	 	yay4.setContentAreaFilled(false); // Set button to be transparent
	 	yay4.setBorderPainted(false); // Remove borders
	 	yay4.setBounds(688, 218, 120, 73); // Set button location
	 	yay4.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	yay4.setActionCommand("yay4Menu1"); // Set action command for the ActionListener
	 	yay4.addActionListener(window); 
	 
	 	this.add(yay4, new Integer(3)); // Add the button to the Pane
	 	
	 	// ileri yay butonu
	 	JButton ileriYay = new JButton();
	 	ileriYay.setOpaque(false); // Set button corners to be transparent
	 	ileriYay.setContentAreaFilled(false); // Set button to be transparent
	 	ileriYay.setBorderPainted(false); // Remove borders
	 	ileriYay.setBounds(855, 235, 40, 40); // Set button location
	 	ileriYay.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		ileriYay.setActionCommand("ileriYayMenu1"); // Set action command for the ActionListener
		ileriYay.addActionListener(window); 
		
	    this.add(ileriYay, new Integer(3)); // Add the button to the Pane
	    
	    //geri meyve butonu
	    JButton geriMeyve = new JButton();
	    geriMeyve.setOpaque(false); // Set button corners to be transparent
	    geriMeyve.setContentAreaFilled(false); // Set button to be transparent
	    geriMeyve.setBorderPainted(false); // Remove borders
	    geriMeyve.setBounds(3, 400, 40, 40); // Set button location
	    geriMeyve.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	    geriMeyve.setActionCommand("geriMeyveMenu1"); // Set action command for the ActionListener
	    geriMeyve.addActionListener(window); 
	
	    this.add(geriMeyve, new Integer(3)); // Add the button to the Pane
	    
	    // meyve1 butonu
	 	JButton meyve1 = new JButton();
	  	meyve1.setOpaque(false); // Set button corners to be transparent
	 	meyve1.setContentAreaFilled(false); // Set button to be transparent
	  	meyve1.setBorderPainted(false); // Remove borders
	 	meyve1.setBounds(75, 385, 120, 73); // Set button location
	 	meyve1.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	meyve1.setActionCommand("meyve1Menu1"); // Set action command for the ActionListener
	 	meyve1.addActionListener(window); 
	 	
	 	this.add(meyve1, new Integer(3)); // Add the button to the Pane
	 	 	    
	 	// meyve2 butonu
	 	JButton meyve2 = new JButton();
	 	meyve2.setOpaque(false); // Set button corners to be transparent
	 	meyve2.setContentAreaFilled(false); // Set button to be transparent
	 	meyve2.setBorderPainted(false); // Remove borders
	  	meyve2.setBounds(282, 385, 120, 73); // Set button location
	 	meyve2.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	  	meyve2.setActionCommand("meyve2Menu1"); // Set action command for the ActionListener
	 	meyve2.addActionListener(window); 
	  	
	 	this.add(meyve2, new Integer(3)); // Add the button to the Pane
	 	 	    
	 	// meyve3 butonu
	 	JButton meyve3 = new JButton();
	 	meyve3.setOpaque(false); // Set button corners to be transparent
	 	meyve3.setContentAreaFilled(false); // Set button to be transparent
	 	meyve3.setBorderPainted(false); // Remove borders
	 	meyve3.setBounds(486, 385, 120, 73); // Set button location
	 	meyve3.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	meyve3.setActionCommand("meyve3Menu1"); // Set action command for the ActionListener
	 	meyve3.addActionListener(window); 
	 	
	    this.add(meyve3, new Integer(3)); // Add the button to the Pane
	 	    
	 	// meyve4 butonu
	    JButton meyve4 = new JButton();
	 	meyve4.setOpaque(false); // Set button corners to be transparent
	    meyve4.setContentAreaFilled(false); // Set button to be transparent
 	 	meyve4.setBorderPainted(false); // Remove borders
	 	meyve4.setBounds(688, 385, 120, 73); // Set button location
	  	meyve4.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	 	meyve4.setActionCommand("meyve4Menu1"); // Set action command for the ActionListener
	 	meyve4.addActionListener(window); 
	  	
	  	this.add(meyve4, new Integer(3)); // Add the button to the Pane
	 	 	
	 	// ileri meyve butonu
	  	JButton ileriMeyve = new JButton();
	 	ileriMeyve.setOpaque(false); // Set button corners to be transparent
	 	ileriMeyve.setContentAreaFilled(false); // Set button to be transparent
	 	ileriMeyve.setBorderPainted(false); // Remove borders
 	 	ileriMeyve.setBounds(850, 395, 40, 40); // Set button location
 	 	ileriMeyve.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	  	ileriMeyve.setActionCommand("ileriMeyveMenu1"); // Set action command for the ActionListener
	  	ileriMeyve.addActionListener(window); 
	  	
 	    this.add(ileriMeyve, new Integer(3)); // Add the button to the Pane
 	    
 	    //quit from kostümler2
 	    JButton quit = new JButton();
		quit.setOpaque(false); // Set button corners to be transparent
		quit.setContentAreaFilled(false); // Set button to be transparent
		quit.setBorderPainted(false); // Remove borders
		quit.setBounds(30, 3, 80, 60); // Set button location
		quit.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		quit.setActionCommand("back"); // Set action command for the ActionListener
		quit.addActionListener(window); 
		
	    this.add(quit, new Integer(3)); // Add the button to the Pane
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image,-5,0,null); // Draw the background Image
	}
	
}

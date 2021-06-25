package com.target.windows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Painter;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import com.target.basegame.DefaultUser;
import com.target.basegame.Main;
import com.target.objects.Images;

public class MainMenu extends Menu{
	private static final long serialVersionUID = -5644518740815531961L;
	private JButton volume;
	private JComponent slider;
	@SuppressWarnings("deprecation")
	public MainMenu(Window window, DefaultUser user) {
		super(window, user);
		try {
			//image = ImageIO.read(new File(Images.MAINMENU.getString())).getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
			image = ImageIO.read(getClass().getResource(Images.MAINMENU.getString()));
			image = image.getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int x=200;
		int y=230;
		
		JButton play = new JButton();
		play.setOpaque(false); // Set button corners to be transparent
		play.setContentAreaFilled(false); // Set button to be transparent
		play.setBorderPainted(false); // Remove borders
	    play.setBounds(x, y, 160, 60); // Set button location
	    play.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	    play.setActionCommand("play"); // Set action command for the ActionListener
	    play.addActionListener(window); 
	  
	    this.add(play, new Integer(3)); // Add the button to the Pane
	    
	    // levels button
		JButton levels = new JButton();
		levels.setOpaque(false); // Set button corners to be transparent
		levels.setContentAreaFilled(false); // Set button to be transparent
		levels.setBorderPainted(false); // Remove borders
		levels.setBounds(x+280, y, 260, 60); // Set button location
		levels.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		levels.setActionCommand("levels"); // Set action command for the ActionListener
		levels.addActionListener(window); 
		
	    this.add(levels, new Integer(3)); // Add the button to the Pane
	    
	    // shop button
		JButton shop = new JButton();
		shop.setOpaque(false); // Set button corners to be transparent
		shop.setContentAreaFilled(false); // Set button to be transparent
		shop.setBorderPainted(false); // Remove borders
		shop.setBounds(x+300, y+100, 260, 60); // Set button location
		shop.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		shop.setActionCommand("shop"); // Set action command for the ActionListener
		shop.addActionListener(window); 
		
	    this.add(shop, new Integer(3)); // Add the button to the Pane
	    
	    // dresses button
		JButton dress = new JButton();
		dress.setOpaque(false); // Set button corners to be transparent
		dress.setContentAreaFilled(false); // Set button to be transparent
		dress.setBorderPainted(false); // Remove borders
		dress.setBounds(x-95, y+100, 340, 60); // Set button location
		dress.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
		dress.setActionCommand("dress"); // Set action command for the ActionListener
		dress.addActionListener(window); 
		
	    this.add(dress, new Integer(3)); // Add the button to the Pane
	    
	    // settings butonu
	    JButton settings = new JButton();
	    settings.setOpaque(false); // Set button corners to be transparent
	    settings.setContentAreaFilled(false); // Set button to be transparent
	    settings.setBorderPainted(false); // Remove borders
	    settings.setBounds(x+410, 10, 60, 40); // Set button location
	    settings.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
	    settings.setActionCommand("settings"); // Set action command for the ActionListener
	    settings.addActionListener(new ActionListener() {

			private boolean flag=false;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag == false) {
					volume = new JButton();
					Image iconimage= null;
					try {
						iconimage = ImageIO.read(getClass().getResource(Images.SES.getString()));
						iconimage = iconimage.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
					ImageIcon icon = new ImageIcon(iconimage);
					volume.setIcon(icon);
					volume.setOpaque(false); // Set button corners to be transparent
					volume.setContentAreaFilled(false); // Set button to be transparent
					volume.setBorderPainted(false); // Remove borders
					volume.setBounds(620, 70, 40, 40); // Set button location
					volume.setBorder(BorderFactory.createLineBorder(Color.ORANGE)); // Set button border color
					volume.setActionCommand("MainMenuVolume"); // Set action command for the ActionListener
				    volume.addActionListener(window); 
				   
				    add(volume, new Integer(3)); // Add the button to the Pane
				    
				    EventQueue.invokeLater(() -> {
				        try {
				          for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
				            if ("Nimbus".equals(laf.getName())) {
				              UIManager.setLookAndFeel(laf.getClassName());
				            }
				          }
				        } catch (Exception e1) {
				          e1.printStackTrace();
				        }
				        slider = makeUI();
				        add(slider);
				    });
				    flag = true;
				} else {
					remove(volume);
					remove(slider);
					revalidate();
					repaint();
					flag = false;
				}
			}
	    	
	    }); 
	   
	    this.add(settings, new Integer(3)); // Add the button to the Pane
	    
		// Add Coin label
	    JLabel coin = new JLabel();
	    Image coinimg= null;
		try {
			coinimg = ImageIO.read(getClass().getResource(Images.PARA.getString()));
			coinimg = coinimg.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	    ImageIcon icon = new ImageIcon(coinimg);
	    coin.setIcon(icon);
	    coin.setBounds(630,10,150,50);
	    this.add(coin);
	    
	    JLabel cointext = new JLabel(Integer.toString(user.getCurrency()));
	    cointext.setFont(new Font("Times New Roman",Font.BOLD,22));
	    cointext.setBounds(740,10,100,38);
	    
	    this.add(cointext);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image,0,0,null); // Draw the background Image
	}
	
	
	
	public JComponent makeUI() {
	    UIDefaults d = new UIDefaults();
	    d.put("Slider:SliderTrack[Enabled].backgroundPainter", new Painter<JSlider>() {
	      @Override 
	      public void paint(Graphics2D g, JSlider c, int w, int h) {
	        int arc         = 10;
	        int trackHeight = 8;
	        int trackWidth  = w - 2;
	        int fillTop     = 4;
	        int fillLeft    = 1;

	        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                           RenderingHints.VALUE_ANTIALIAS_ON);
	        g.setStroke(new BasicStroke(1.5f));
	        g.setColor(Color.GRAY);
	        g.fillRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);

	        int fillBottom = fillTop + trackHeight;
	        int fillRight  = xPositionForValue(
	            c.getValue(), c,
	            new Rectangle(fillLeft, fillTop, trackWidth, fillBottom - fillTop));

	        g.setColor(Color.ORANGE);
	        g.fillRect(fillLeft + 1, fillTop + 1, fillRight - fillLeft, fillBottom - fillTop);

	        g.setColor(Color.WHITE);
	        g.drawRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);
	      }
	      //@see javax/swing/plaf/basic/BasicSliderUI#xPositionForValue(int value)
	      protected int xPositionForValue(int value, JSlider slider, Rectangle trackRect) {
	        int min = slider.getMinimum();
	        int max = slider.getMaximum();
	        int trackLength = trackRect.width;
	        double valueRange = (double) max - (double) min;
	        double pixelsPerValue = (double) trackLength / valueRange;
	        int trackLeft = trackRect.x;
	        int trackRight = trackRect.x + (trackRect.width - 1);
	        int xPosition;

	        xPosition = trackLeft;
	        xPosition += Math.round(pixelsPerValue * ((double) value - min));

	        xPosition = Math.max(trackLeft, xPosition);
	        xPosition = Math.min(trackRight, xPosition);

	        return xPosition;
	      }
	    });

	    JSlider slider = new JSlider();
	    slider.putClientProperty("Nimbus.Overrides", d);
	    slider.setBounds(680,77,150,10);
	    return slider;
	}

}

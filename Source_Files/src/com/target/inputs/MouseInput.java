package com.target.inputs;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Point;

public class MouseInput extends MouseAdapter{
	public static int x_pos,y_pos; // Mouse Position
	public static boolean flag;
	public static int len_x;
	public static int len_y;
	public static boolean drag;
	public static int static_arrow_move_x;
	public static int static_arrow_move_y;	
	@Override
	public void mouseClicked(MouseEvent e) {
		x_pos = e.getX();
		y_pos = e.getY();
		System.out.println("X Position: " + x_pos
				+ "\nY Position: "+y_pos);
		
	}
	@Override
    public void mousePressed(MouseEvent event) {
		Point point = event.getPoint();
		drag = true;
		System.out.println("mousePressed at " + point);
		len_x = point.x;
		len_y = point.y;

    }
 
    @Override
    public void mouseReleased(MouseEvent event) {
    	Point point = event.getPoint();
    	len_x = len_x - point.x;
    	len_y = point.y- len_y  ;
    	drag = false;
    	if( len_y > 0)
    		flag=true;
    	
    	if(len_x > 13)
    		len_x = 13;
    	if(len_y > 41)
    		len_y = 41;
    	System.out.println("length  of x = "+len_x+" length of y = "+len_y);    
    }
 
	@Override
	public void mouseDragged(MouseEvent e) {
		Point point = e.getPoint();
		static_arrow_move_x = point.x;
		static_arrow_move_y =  point.y; 
	}
	

}

package com.target.basegame;

import java.awt.Graphics;
import java.util.ArrayList;


import com.target.objects.Arrow;
import com.target.objects.Bow;
import com.target.objects.Goal;
import com.target.objects.Objects;
import com.target.objects.Obstacle;
import com.target.objects.Visual;

public class Handler {
	
	private ArrayList<Visual> gameObjects;
	private Visual Arrow_for_boundry;
	public int Collision;
	// Initialize 
	public Handler() {
		gameObjects = new ArrayList<>();
	}
	
	// Update all the objects in the ArrayList
	public void update() {
		for(Visual obj: gameObjects)
			obj.update();
			
	}
	
	// Render all the objects in the ArrayList
	public void render(Graphics g) {
		for(int i=0 ; i<gameObjects.size() ; i++) {
			gameObjects.get(i).render(g);
		}
	}
	
	// Add an object to the ArrayList
	public void addObject(Objects obj) {
		gameObjects.add(obj);
		if(obj instanceof Arrow)
			Arrow_for_boundry = obj;
	}
	
	// Remove and object from the ArrayList
	public void removeObject(Visual obj) {
		gameObjects.remove(obj);
	}
	
	public ArrayList<Visual> getGameObjects() {
		return gameObjects;
	}
	public void clean() {
		if(!gameObjects.isEmpty())
			gameObjects.clear();
	}
	
	public int collision() {		
		for(Visual obj1 : getGameObjects()) {
			Objects obj = (Objects) obj1;
			if(!(obj instanceof Bow) && obj.Boundry().intersects(Arrow_for_boundry.Boundry()) && !(obj instanceof Arrow)) {
				if(obj instanceof  Obstacle) {
					Collision = 0;
					return 0;
				}
				else if(obj instanceof Goal) {
					Collision = 1;
					return 1;
				}
			}
		}
		Collision = -1;
		return -1;
	}
}

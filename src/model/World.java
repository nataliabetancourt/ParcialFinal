package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {
	
	private PApplet app;
	private Marco marco;
	private ArrayList<Polo> poloCircles;
	private int numPolo;

	public World(PApplet app) {
		this.app = app;
		
		//Attributes
		numPolo = 20;
		
		//Classes and lists
		marco = new Marco(app);
		poloCircles = new ArrayList<>();
		
		//Creating polo objects
		for (int i = 0; i < numPolo; i++) {
			int xTemp = (int) app.random(20, 680);
			int yTemp = (int) app.random(20, 680);
			poloCircles.add(new Polo(app, xTemp, yTemp));
		}
		
	}
	
	public void draw() {
		//Drawing and moving polo circles
		for (int i = 0; i < poloCircles.size(); i++) {
			poloCircles.get(i).draw();
			new Thread(poloCircles.get(i)).start();
		}
		
		//Drawing and moving marco circle
		marco.draw();
		new Thread(marco).start();
		

	}

}

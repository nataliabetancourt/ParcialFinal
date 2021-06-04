package model;

import processing.core.PApplet;

public class World {
	
	private PApplet app;
	private Marco marco;

	public World(PApplet app) {
		this.app = app;
		
		//Classes
		marco = new Marco(app);
		
	}
	
	public void draw() {
		marco.draw();

	}

}

package model;

import processing.core.PApplet;

public class Marco {

	private PApplet app;
	private int x, y, d;
	
	public Marco(PApplet app) {
		this.app = app;
		
		//Attributes
		this.x = (int) app.random(20, 680);
		this.y = (int) app.random(20, 680);
		this.d = 30;
	
	}
	
	public void draw() {
		app.strokeWeight(4);
		app.stroke(207, 21, 89);
		app.circle(x, y, d);

	}

}

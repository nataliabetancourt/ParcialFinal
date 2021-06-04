package controller;

import model.World;
import processing.core.PApplet;

public class Controller {
	
	private PApplet app;
	private World world;

	public Controller(PApplet app) {
		this.app = app;
		
		world = new World(app);
	}
	
	public void draw() {
		world.draw();
		
	}

}

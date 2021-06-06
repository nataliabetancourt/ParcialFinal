package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {
	
	private PApplet app;
	private Marco marco;
	private Polo nearestPolo;
	private ArrayList<Polo> poloCircles;
	private int numPolo;
	private float a;

	public World(PApplet app) {
		this.app = app;
		
		//Attributes
		numPolo = 10;
		
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
			//Variable to make code shorter
			Polo polo = poloCircles.get(i);
			
			polo.draw(marco.isSayMarco());
			new Thread(polo).start();
			
			//Determine the closest polo to marco and then have marco follow it when the message is being sent
			if (marco.isSayMarco()) {
				marco.followPolo(polo);
				caughtPolo();
			}
		}
		
		//Drawing and moving marco circle
		marco.draw();
		new Thread(marco).start();

	}
	
	private void caughtPolo() {
		for (int i = 0; i < poloCircles.size(); i++) {
			//Variable to make code shorter
			Polo polo = poloCircles.get(i);
			
			//Verify that marco "caught" polo to eliminate polo
			if ((app.dist(marco.getX(), marco.getY(), polo.getX(), polo.getY())) < marco.getD()/2) {
				poloCircles.remove(polo);
			}
		}
	}

}

package model;

import processing.core.PApplet;

public class Marco implements Runnable{

	private PApplet app;
	private int x, y, d, dirX, dirY, speed;
	
	public Marco(PApplet app) {
		this.app = app;
		
		//Attributes
		this.x = (int) app.random(20, 680);
		this.y = (int) app.random(20, 680);
		this.d = 60;
		this.dirX = (int) (app.random(2));
		this.dirY = (int) (app.random(2));
		this.speed = 4;
		
		//Direction for Marco randomly made
		if (dirX == 0) {
			dirX = 1;
		} else {
			dirX = -1;
		}

		if (dirY == 0) {
			dirY = 1;
		} else {
			dirY = -1;
		}
	
	}
	
	public void draw() {
		app.fill(240, 68, 133, 90);
		app.strokeWeight(7);
		app.stroke(207, 21, 89);
		app.circle(x, y, d);
	}
	
	public void move() {
		x += dirX * speed;
		y += dirY * speed;
		
		if (x < 0 || x > 700) {
			dirX = dirX * (-1);
		}
		
		if (y < 0 || y > 700) {
			dirY = dirY * (-1);
		}
	}

	@Override
	public void run() {
		move();
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

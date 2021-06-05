package model;

import processing.core.PApplet;
import processing.core.PConstants;

public class Polo implements Runnable {

	private PApplet app;
	private int x, y, d, dirX, dirY, speed;

	public Polo(PApplet app, int x, int y) {
		this.app = app;
		
		//Attributes
		this.x = x;
		this.y = y;
		this.d = 40;
		this.dirX = (int)(app.random(2));
		this.dirY = (int)(app.random(2));
		this.dirX = (int)(app.random(2));
		this.speed = 2;
		
		//Direction for Polo randomly made
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
	
	public void draw(boolean message) {
		app.fill(23, 225, 219);
		app.noStroke();
		app.circle(x, y, d);
		
		//Message from world to send position
		if (message) {
			app.fill(80);
			app.textSize(14);
			app.textAlign(PConstants.CENTER);
			app.text("Polo", x, y+(d-5));
		}

	}

	public void move() {
		//Regular movement based on direction and speed
		x += speed * dirX;
		y += speed * dirY;
		
		//Borders
		if (x <= 20 || x >= 680) {
			dirX *= (-1);
		}
		
		if (y <= 20 || y >= 680) {
			dirY *= (-1);
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getDirX() {
		return dirX;
	}
	
	public int getDirY() {
		return dirY;
	}

}

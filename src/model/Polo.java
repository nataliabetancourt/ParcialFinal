package model;

import processing.core.PApplet;
import processing.core.PConstants;

public class Polo implements Runnable, Comparable<Polo> {

	private PApplet app;
	private int x, y, d, dirX, dirY, speed, dirTimer, dir, distMarco;

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
		this.dirTimer = 80;
		this.dir = 0;
		
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
			app.text(x + " , " + y, x, y+(d+10));
		}
		
		//Counter for the change in direction so its not as fast
		if (dirTimer > 0) {
			dirTimer--;
		}
		
		//Choosing a random direction
		if (dirTimer == 0) {
			dir = (int) app.random(1,4);
			dirTimer = 80;
		}
	}

	public void move() {
		//Regular movement based on direction and speed
		x += dirX * speed;
		y += dirY * speed;
		
		//Switch to randomly change directions after a few seconds
		switch (dir) {
		case 1:
			dirX = -1;
			break;
		case 2:
			dirX = 1;
			break;
		case 3:
			dirY = -1;
		break;
		case 4:
			dirY = 1;
		break;
		}
		
		//Borders
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

	@Override
	public int compareTo(Polo o) {
		return 0;
	}
}

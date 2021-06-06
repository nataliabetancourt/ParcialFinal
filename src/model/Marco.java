package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

public class Marco implements Runnable{

	private PApplet app;
	private Polo nearestPolo;
	private int d, dirX, dirY, speed, sayMarcoTimer, showMesTimer, radius;
	private float x, y, a;
	private boolean sayMarco, trapped;
	
	public Marco(PApplet app) {
		this.app = app;
		
		//Attributes
		this.x = (int) app.random(20, 680);
		this.y = (int) app.random(20, 680);
		this.d = 60;
		this.dirX = (int) (app.random(2));
		this.dirY = (int) (app.random(2));
		this.speed = 4;
		this.sayMarco = false;
		this.sayMarcoTimer = 150;
		this.showMesTimer = 200;
		this.radius = 600;
		this.a = (float) 0.3;
		this.trapped = false;
		
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
		//Timer for sayMarcoTimer
		if (sayMarcoTimer > 0) {
			sayMarcoTimer--;
		}
		
		//Marco circle
		app.fill(207, 21, 89);
		app.circle(x, y, d);
		
		//Timer to show message and send message to world
		if (sayMarcoTimer == 0) {
			app.fill(80);
			app.textSize(20);
			app.textAlign(PConstants.CENTER);
			app.text("Marco", x, y+(d-10));
			showMesTimer--;
			sayMarco = true;
			if (showMesTimer == 0) {
				sayMarcoTimer = 150;
				showMesTimer = 200;
				sayMarco = false;
			}
		}

	}
	
	public void move() {
		x += dirX * speed;
		y += dirY * speed;
		
		if (x < 20 || x > 680) {
			dirX *= (-1);
		}
		
		if (y < 20 || y > 680) {
			dirY *= (-1);
		}
	}
	
	public void followPolo(Polo polo) {
		
		//Calculate if polo has entered the surrounding radius and classify it has nearest polo
		if (app.dist(x, y, polo.getX(), polo.getY()) < radius/2) {
			//Stops regular marco movement
			trapped = true;
			nearestPolo = polo;	
		}
	
		//Makes marco chase the designated polo
		if (trapped) {
			x += (nearestPolo.getX()-x)*a;
			y += (nearestPolo.getY()-y)*a;
		}
			
		//Trapped is used to continue the regular Marco movement
		trapped = false;
		
	}

	@Override
	public void run() {
		if (sayMarco == false) {
			move();
		}
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isSayMarco() {
		return sayMarco;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public int getD() {
		return d;
	}
	
}

package snake;

import java.awt.Rectangle;

public class Snake {

	private int x = 150;
	private int y = 200;
	private int h = 120;
	private int w = 100;
	private int Xdir = -4;
	private int Ydir = -4;
	private int health = 3;
	private int score = 0;
	private int rocketX;
	private int rocketY;
	private int rocketW =150;
	private int rocketH = 50;
	private int rocketXdir = 7;
	
	private String lastMove;
	private boolean attacking = false;
	
	
	public void attack(String command) {
		switch (command) {
		case "attack":
			attacking = true;
			setRocketY(y);
			setRocketX(getRocketX()+getRocketXdir());
			if (getRocketX()>1400) {
				attack("stop");
			}
			
			break;
		case "stop":
			setRocketX(x);
			setRocketY(y);
			attacking = false;
			break;
		}
	}

	public void change(String command) {
		switch (command) {
		case "shrink":
			h = h / 3 * 2;
			w = w / 3 * 2;
			break;
		case "grow":
			h = h + 15;
			w = w + 15;
			score = score + 100;
			break;
		case "hurt":
			health--;
			break;
		case "health":
			health++;
			break;
		}
	}

	public void moveLeft() {
		x += Xdir;
		lastMove = "left";
		if (new Rectangle(x, y, h, w).intersects(new Rectangle(0, 0, 5, 960))) {
			x -= Xdir;

		}
	}

	public void moveRight() {
		x -= Xdir;
		lastMove = "right";
		if (new Rectangle(x, y, h, w).intersects(new Rectangle(1410, 0, 5, 970))) {
			x += Xdir;
		}
	}

	public void moveDown() {
		y -= Ydir;
		lastMove = "down";
		if (new Rectangle(x, y, h, w).intersects(new Rectangle(0, 948, 1395, 5))) {
			y += Ydir;

		}
	}

	public void moveUp() {
		y += Ydir;
		lastMove = "up";
		if (new Rectangle(x, y, h, w).intersects(new Rectangle(0, 50, 1395, 5))) {
			y -= Ydir;

		}
	}

	// GETTERS SETTERS

	public String getLastMove() {
		return lastMove;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getXdir() {
		return Xdir;
	}

	public void setXdir(int xdir) {
		Xdir = xdir;
	}

	public int getYdir() {
		return Ydir;
	}

	public void setYdir(int ydir) {
		Ydir = ydir;
	}

	public void setLastMove(String lastMove) {
		this.lastMove = lastMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	public int getRocketX() {
		return rocketX;
	}

	public void setRocketX(int rocketX) {
		this.rocketX = rocketX;
	}

	public int getRocketY() {
		return rocketY;
	}

	public void setRocketY(int rocketY) {
		this.rocketY = rocketY;
	}

	public int getRocketW() {
		return rocketW;
	}

	public void setRocketW(int rocketW) {
		this.rocketW = rocketW;
	}

	public int getRocketH() {
		return rocketH;
	}

	public void setRocketH(int rocketH) {
		this.rocketH = rocketH;
	}

	public int getRocketXdir() {
		return rocketXdir;
	}

	public void setRocketXdir(int rocketXdir) {
		this.rocketXdir = rocketXdir;
	}

}

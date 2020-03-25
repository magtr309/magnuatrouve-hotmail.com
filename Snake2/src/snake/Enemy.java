package snake;

import java.util.Random;

public abstract class Enemy {
	private int x;
	private int y;
	private int w;
	private int h;
	private int Xdir;
	private int Ydir;

	public Enemy(int x, int y, int w, int h, int Xdir, int Ydir) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.Xdir = Xdir;
		this.Ydir = Ydir;

	}

	public abstract void move();
	public abstract void change(String command);

	public int random(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
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

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

}

package snake;

public class Walt extends Enemy {
	int laserX=2000;
	int laserY;
	int laserW = 100;
	int laserH = 20;
	int laserXdir = -4;
	int health = 1000;
	private boolean entered = false;
	private boolean damaged = false;
	Music music = new Music();

	public Walt(int x, int y, int w, int h, int Xdir, int Ydir) {
		super(x, y, w, h, Xdir, Ydir);

	}

	public void takeDamage() {
		health--;
		setDamaged(true);
		if (health <1) {
			laserXdir=0;
			laserX=2000;
			setX(2000);
			music.playMusic("musik\\\\killwalt.wav");
		}
	}

	@Override
	public void move() {
		// Enter from above
		if (!entered && getY() == 60) {
			entered = true;
		}
		// Moving
		setY(getY() - getYdir());

		if (entered && getY() < 50) {
			setYdir(getYdir() - getYdir() * 2);
		}

		if (entered && getY() > 570) {
			setYdir(getYdir() - getYdir() * 2);
		}
		// Shooting
		setLaserX(getLaserX() + getLaserXdir());
		if (getLaserX() < 0) {
			setLaserX(getX() + 200);
			setLaserY(getY() + 200);
		}

	}

	@Override
	public void change(String command) {

	}

	public int getLaserX() {
		return laserX;
	}

	public void setLaserX(int laserX) {
		this.laserX = laserX;
	}

	public int getLaserY() {
		return laserY;
	}

	public void setLaserY(int laserY) {
		this.laserY = laserY;
	}

	public int getLaserW() {
		return laserW;
	}

	public void setLaserW(int laserW) {
		this.laserW = laserW;
	}

	public int getLaserH() {
		return laserH;
	}

	public void setLaserH(int laserH) {
		this.laserH = laserH;
	}

	public int getLaserXdir() {
		return laserXdir;
	}

	public void setLaserXdir(int laserXdir) {
		this.laserXdir = laserXdir;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

}

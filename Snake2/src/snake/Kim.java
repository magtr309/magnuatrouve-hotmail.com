package snake;

public class Kim extends Enemy {
	public Kim(int x, int y, int w, int h, int Xdir, int Ydir) {
		super(x, y, w, h, Xdir, Ydir);

	}

	@Override
	public void move() {
		setX(getX() + getXdir());
		setY(getY() + getYdir());

		if (getX() < 0) {
			setXdir(getXdir() - getXdir() * 2);
		}

		if (getX() > 1280) {
			setXdir(getXdir() - getXdir() * 2);
		}

		if (getY() < 50) {
			setYdir(getYdir() - getYdir() * 2);
		}

		if (getY() > 870) {
			setYdir(getYdir() - getYdir() * 2);
		}

	}

	@Override
	public void change(String command) {
		switch (command) {
		case "pos":
			setX(random(20, 1200));
			setY(random(20, 800));
			break;
		}
	}

}

package snake;

public class Xanax extends Powerup {
	private boolean visable = false;

	public Xanax(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void change(String command) {
		switch (command) {
		case "pos":
			setX(random(50, 900));
			setY(random(20, 850));
			break;
		}

	}

	public boolean isVisable() {
		return visable;
	}

	public void setVisable(boolean visable) {
		this.visable = visable;

	}
}

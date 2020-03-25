package snake;

public class Shrink extends Powerup {
private boolean visable = false;
	public Shrink(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	@Override
	public void effect() {
		System.out.println("aaii ");

	}



	@Override
	public void change(String command) {
		switch (command) {
		case "pos":
			setX(random(20, 900));
			setY(random(70, 800));
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

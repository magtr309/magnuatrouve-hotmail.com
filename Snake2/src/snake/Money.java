package snake;

public class Money extends Powerup{
	public Money(int x, int y, int w, int h) {
		super(x, y, w, h);
	
	}

	@Override
	public void effect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void change(String command) {
	switch (command) {
	case "pos":
		setX(random(20, 900));
		setY(random(60, 900));
		break;
	}
	
	}
}

package snake;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

public class MyListener implements KeyListener, ActionListener, MouseListener {
	private Timer timer;
	int delay = 1;
	private int snakeDir = 0;
	Snake snake = new Snake();
	Music music = new Music();
	Money money = new Money(400, 400, 70, 35);
	Kim kim = new Kim(600, 600, 100, 100, 2, 2);
	Shrink shrink = new Shrink(5000, 500, 110, 170);
	Xanax xanax = new Xanax(2000, 600, 80, 30);
	Walt walt = new Walt(1000, -500, 400, 400, 0, -1);

	public MyListener() {
		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Starts
		timer.start();
		
		if (snake.isAttacking()) {
			snake.attack("attack");
		}

		if (!snake.isAttacking()) {
			walt.setDamaged(false);
		}

		// If you die you die game over bby
		if (snake.getHealth() == 0) {
			timer.stop();
			music.playMusic("musik\\\\scoop.wav");
		}

		// Handles Players movement
		switch (snakeDir) {
		case 1:
			snake.moveUp();
			break;
		case 2:
			snake.moveDown();
			break;
		case 3:
			snake.moveLeft();
			break;
		case 4:
			snake.moveRight();
			break;
		}
		
		// Handles walt disneys movement
		if (snake.getScore() > 1000) {
			walt.move();
			if (walt.getY() == -499) {
				music.playMusic("musik\\\\walt.wav");
			}
		}
		
		// if players rocket touches walt disney
		if (snake.isAttacking() && new Rectangle(walt.getX(), walt.getY() - 100, walt.getW(), walt.getH()).intersects(
				new Rectangle(snake.getRocketX(), snake.getRocketY(), snake.getRocketW(), snake.getRocketH()))) {
			walt.takeDamage();

		}
		// if player collides with walt disneys rocket
		if (new Rectangle(snake.getX(), snake.getY(), snake.getW(), snake.getH())
				.intersects(new Rectangle(walt.getLaserX(), walt.getLaserY(), walt.getLaserW(), walt.getLaserH()))) {
			walt.setLaserX(walt.getX() + 200);
			walt.setLaserY(walt.getY() + 200);
			snake.change("hurt");
		}

		// If player collides with walt disney
		if (new Rectangle(walt.getX(), walt.getY(), walt.getW(), walt.getH())
				.intersects(new Rectangle(snake.getX(), snake.getY(), snake.getW(), snake.getH()))) {
			snake.setHealth(0);
		}

		// Handles kim kardashians movement
		kim.move();
		// If Player collides with kim
		if (new Rectangle(kim.getX(), kim.getY(), kim.getW(), kim.getH())
				.intersects(new Rectangle(snake.getX(), snake.getY(), snake.getW(), snake.getH()))) {
			music.playMusic("musik\\\\kim.wav");
			kim.change("pos");
			snake.change("hurt");

		}
		// if Player collides with cash
		if (new Rectangle(snake.getX(), snake.getY(), snake.getW(), snake.getH())
				.intersects(new Rectangle(money.getX(), money.getY(), money.getW(), money.getH()))) {
			money.change("pos");
			snake.change("grow");
		}
		// Powrup xanax visibility
		if (snake.getScore() % 9 == 2) {
			xanax.setVisable(false);
		}
		if (!xanax.isVisable() && snake.getScore() % 9 == 3) {
			xanax.change("pos");
			xanax.setVisable(true);
		}

		// if Player collides with xanax
		if (new Rectangle(snake.getX(), snake.getY(), snake.getW(), snake.getH())
				.intersects(new Rectangle(xanax.getX(), xanax.getY(), xanax.getW(), xanax.getH()))) {
			xanax.setX(1500);
			snake.change("health");

		}

		// Handles Visibiliy of powerup hennesy (Shrink)
		if (snake.getScore() % 9 == 6) {
			shrink.setVisable(false);
		}
		if (!shrink.isVisable() && snake.getScore() % 9 == 5) { // When modulus of score = 5, generate hennessy at
																// random location
			shrink.change("pos");
			shrink.setVisable(true);
		}
		// If player collides with hennesy (shrink)
		if ((new Rectangle(snake.getX(), snake.getY(), snake.getW(), snake.getH()))
				.intersects(new Rectangle(shrink.getX(), shrink.getY(), shrink.getW(), shrink.getH()))) {
			music.playMusic("musik\\\\surgery.wav");
			shrink.setX(1500);
			snake.change("shrink");
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			snakeDir = 1;
			break;
		case KeyEvent.VK_DOWN:
			snakeDir = 2;
			break;
		case KeyEvent.VK_LEFT:
			snakeDir = 3;
			break;
		case KeyEvent.VK_RIGHT:
			snakeDir = 4;
			break;
		case KeyEvent.VK_SPACE:
			snake.attack("attack");
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		System.out.println("x " + x + "y " + y);
		if ((snake.getHealth() == 0) && x >= 960 && x < 1260 && y >= 210 && y <= 335) {
			System.out.println("se på fan");

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}

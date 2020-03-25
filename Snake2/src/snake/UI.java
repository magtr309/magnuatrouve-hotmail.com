package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class UI extends JPanel {
	MyListener listener = new MyListener(); // key, mouse and actionlistener
	private boolean menu = true;

	// Player Images
	Image normalKanye;
	Image revKanye;
	Image grumpyKanye;
	Image revGrumpyKanye;
	Image happyKanye;
	Image revHappyKanye;
	Image laserKanye;
	Image beam;

	// Enemy Images
	Image walt;
	Image dmgWalt;
	Image laser;
	Image kim;

	// Other Images
	Image background;
	Image gameOver;
	Image dance;
	Image kanyeQuest;

	// Powerup images
	Image pilly;
	Image cash;
	Image henny;
	
	String waltDmg = "pic\\\\dmgWalt.png";
	String kanyesBeam = "pic\\\\beam.png";
	String kanyeLaser = "pic\\\\laserKanye.png";
	String shoot = "pic\\\\laser.png";
	String disney = "pic\\\\walt.png";
	String revhappy = "pic\\\\revHappyKanye.png";
	String happy = "pic\\\\happyKanye.png";
	String revgrump = "pic\\\\revGrumpyKanye.png";
	String pill = "pic\\\\pilly.png";
	String normal = "pic\\\\normalKanye.png";
	String rev = "pic\\\\revKanye.png";
	String bill = "pic\\\\cash.png";
	String hen = "pic\\\\henny.png";
	String kimmy = "pic\\\\kim.png";
	String mansion = "pic\\\\mansion.jpg";
	String dead = "pic\\\\dead.jpg";
	String grump = "pic\\\\grumpyKanye.png";
	String gif = "pic\\\\dance.gif";
	String snake = "pic\\\\snake.png";

	public UI() {

	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		dmgWalt = Toolkit.getDefaultToolkit().getImage(waltDmg);
		beam = Toolkit.getDefaultToolkit().getImage(kanyesBeam);
		laserKanye = Toolkit.getDefaultToolkit().getImage(kanyeLaser);
		laser = Toolkit.getDefaultToolkit().getImage(shoot);
		walt = Toolkit.getDefaultToolkit().getImage(disney);
		happyKanye = Toolkit.getDefaultToolkit().getImage(happy);
		revHappyKanye = Toolkit.getDefaultToolkit().getImage(revhappy);
		pilly = Toolkit.getDefaultToolkit().getImage(pill);
		normalKanye = Toolkit.getDefaultToolkit().getImage(normal);
		revKanye = Toolkit.getDefaultToolkit().getImage(rev);
		cash = Toolkit.getDefaultToolkit().getImage(bill);
		henny = Toolkit.getDefaultToolkit().getImage(hen);
		kim = Toolkit.getDefaultToolkit().getImage(kimmy);
		background = Toolkit.getDefaultToolkit().getImage(mansion);
		gameOver = Toolkit.getDefaultToolkit().getImage(dead);
		revGrumpyKanye = Toolkit.getDefaultToolkit().getImage(revgrump);
		grumpyKanye = Toolkit.getDefaultToolkit().getImage(grump);
		dance = Toolkit.getDefaultToolkit().getImage(gif);
		kanyeQuest = Toolkit.getDefaultToolkit().getImage(snake);

		// Background
		g.drawImage(background, 1, 1, 1400, 1000, this);

		// TopPanel
		g.setColor(Color.black);
		g.fillRect(0, 0, 1395, 50);
		g.setFont(new Font("TimesRoman", Font.BOLD, 40));
		g.setColor(Color.green);
		g.drawString("Bank: " + listener.snake.getScore(), 10, 40);
		g.drawString("Health: " + listener.snake.getHealth(), 1200, 40);

		// Borders
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, 5, 967); // left
		g.fillRect(0, 0, 1395, 5); // toptop
		g.fillRect(0, 50, 1395, 5); // top
		g.fillRect(1389, 0, 5, 970); // right
		g.fillRect(0, 967, 1395, 5); // bottom

		// Handles players facial expressions and direction
		if (listener.snake.isAttacking()) {	
			g2d.drawImage(beam, listener.snake.getRocketX(), listener.snake.getRocketY(), listener.snake.getRocketW(),
					listener.snake.getRocketH(), this);
			
			g2d.drawImage(laserKanye, listener.snake.getX(), listener.snake.getY(), listener.snake.getW(),
					listener.snake.getH(), this);
		} else {

			if (listener.snake.getHealth() <= 1) { // Kanske kan bli av med all gets om man sätter en bildvariabel som
													// byts?
				if (listener.snake.getLastMove() == "left") {
					g2d.drawImage(revGrumpyKanye, listener.snake.getX(), listener.snake.getY(), listener.snake.getW(),
							listener.snake.getH(), this);
				} else {
					g2d.drawImage(grumpyKanye, listener.snake.getX(), listener.snake.getY(), listener.snake.getW(),
							listener.snake.getH(), this);
				}
			} else if (listener.snake.getHealth() > 1 && listener.snake.getHealth() < 5) {
				if (listener.snake.getLastMove() == "left") {
					g2d.drawImage(normalKanye, listener.snake.getX(), listener.snake.getY(), listener.snake.getW(),
							listener.snake.getH(), this);
				} else {
					g2d.drawImage(revKanye, listener.snake.getX(), listener.snake.getY(), listener.snake.getW(),
							listener.snake.getH(), this);

				}
			} else if (listener.snake.getHealth() >= 5) {
				if (listener.snake.getLastMove() == "left") {
					g2d.drawImage(revHappyKanye, listener.snake.getX(), listener.snake.getY(), listener.snake.getW(),
							listener.snake.getH(), this);
				} else {
					g2d.drawImage(happyKanye, listener.snake.getX(), listener.snake.getY(), listener.snake.getW(),
							listener.snake.getH(), this);
				}
			}
		}

		// xanax
		g2d.drawImage(pilly, listener.xanax.getX(), listener.xanax.getY(), listener.xanax.getW(), listener.xanax.getH(),
				this);

		// Hennesy
		g2d.drawImage(henny, listener.shrink.getX(), listener.shrink.getY(), listener.shrink.getW(),
				listener.shrink.getH(), this);

		// Kim
		g2d.drawImage(kim, listener.kim.getX(), listener.kim.getY(), listener.kim.getW(), listener.kim.getH(), this);

		// Money
		g2d.drawImage(cash, listener.money.getX(), listener.money.getY(), listener.money.getW(), listener.money.getH(),
				this);

		// walts laser
		g2d.drawImage(laser, listener.walt.getLaserX(), listener.walt.getLaserY(), listener.walt.getLaserW(),
				listener.walt.getLaserH(), this);
		// walts hp
		g.setFont(new Font("TimesRoman", Font.BOLD, 40));
		g.setColor(Color.red);
		g.drawString("Boss - Walt Disney: "+listener.walt.getHealth()+"hp", 450, 40);
		// walt
		if (listener.walt.isDamaged()) {
			g2d.drawImage(dmgWalt, listener.walt.getX(), listener.walt.getY(), listener.walt.getW(), listener.walt.getH(),
					this);
		} else {
		g2d.drawImage(walt, listener.walt.getX(), listener.walt.getY(), listener.walt.getW(), listener.walt.getH(),
				this);
		}
		// Game over menu
		if (listener.snake.getHealth() == 0) {
			g.drawImage(gameOver, 1, 1, 1400, 1000, this);
			g.setFont(new Font("TimesRoman", Font.BOLD, 60));
			g.setColor(Color.black);
			g.fillRect(950, 200, 320, 120);
			g.setColor(Color.cyan);
			g.fillRect(960, 210, 300, 100);
			g.setColor(Color.black);
			g.drawString("MENU", 1020, 280);

		}
		repaint();
	}

	public boolean isMenu() {
		return menu;
	}

	public void setMenu(boolean menu) {
		this.menu = menu;
	}

}

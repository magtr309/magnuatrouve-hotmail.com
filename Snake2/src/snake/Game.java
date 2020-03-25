package snake;

import javax.swing.JFrame;
public class Game {
	JFrame window = new JFrame();
	UI ui = new UI();
	Music music = new Music();


	public void createGame() {
		window.setBounds(20, 20, 1400, 1000);
		window.setTitle("KanyeQuest");
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addKeyListener(ui.listener);
		window.addMouseListener(ui.listener);
		window.add(ui);

		music.playMusic("musik\\\\loveit.wav");
		
	}
}

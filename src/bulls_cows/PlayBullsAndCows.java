package bulls_cows;

import java.awt.EventQueue;

import javax.swing.JFrame;

import bulls_cows.graphic.BullsAndCowsGraphic;

public class PlayBullsAndCows {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				BullsAndCowsGraphic viewFrame = new BullsAndCowsGraphic();
				viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				viewFrame.setVisible(true);
			}
		});
	}

}

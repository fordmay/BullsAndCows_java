package bulls_cows.graphic;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import bulls_cows.engine.MainPrg;
import res.ResourceLoader;
/**
 * @author   Dmitriy Zheliabin <d.u.zheliabin@gmail.com>
 * @version  1.0
 * @since 	 11.05.2015
 */
public class BullsAndCowsGraphic extends View{
	private static final long serialVersionUID = 1988;
	private int checkButton_Number = 0;
	private int id = 0;
	private String text = "The number is already generated.";
	private MainPrg mainPrg;
	
	public BullsAndCowsGraphic(){
		super();
		setTitle("Bulls and Cows");
		setIconImage(ResourceLoader.loadImage("Cultures-Bull-icon.png"));
		mainPrg = new MainPrg();
		mainPrg.setRandomNumber();
//		text = mainPrg.getRandomNumber();//перевірка, Видалити
		textLabel.setText(text);
	}
	@Override
	protected void useButton_Number(String nameButton, JButton button){
		if(text.equals(textLabel.getText())){
			textLabel.setText("");
		}
		textLabel.setText(textLabel.getText() + nameButton);
		button.setEnabled(false);
		checkButton_Number++;
		buttons[10].setEnabled(true);
		buttons[10].setFocusable(true);
		if(checkButton_Number==4){
			setEnabledButton_Number(false);
			buttons[11].setEnabled(true);
			buttons[11].setFocusable(true);
		}
	}
	@Override
	protected void useButton_clean(){
		textLabel.setText("");
		setEnabledButton_Number(true);
		checkButton_Number = 0;
		setEnabledButton_OK_clean(false);
	}
	@Override
	protected void useButton_OK(){
		mainPrg.setResult(textLabel.getText());
		String numbID = (++id)<10 ? "   "+id : " "+id;
		textArea.setText(textArea.getText()+numbID+"  -  "+textLabel.getText()+"  -  "+mainPrg.getResult()+"\n");
		textLabel.setText("");
		setEnabledButton_Number(true);
		checkButton_Number = 0;
		mainPrg.setResetResult();
		if(mainPrg.getCheckWin()){
			JOptionPane.showMessageDialog(rootPane,"You Win!\nNumber is: "+mainPrg.getRandomNumber(),
					"Result",JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(ResourceLoader.loadImage("bull-icon.png")));
			textLabel.setText("You Win!!!");
			setEnabledButton_Number(false);
			setEnabledButton_OK_clean(false);	
		}else{
			text = "Try to guess!";
			textLabel.setText(text);
			setEnabledButton_OK_clean(false);
		}
	}
	@Override
	protected void setNewGame(){
		text = "New number is ready!";
//		text = mainPrg.getRandomNumber();//перевірка, Видалити
		textLabel.setText(text);
		textArea.setText("");
		checkButton_Number = 0;
		setEnabledButton_Number(true);
		setEnabledButton_OK_clean(false);
		mainPrg.setRandomNumber();
		mainPrg.setResetCheckWin();
	}
	private void setEnabledButton_Number(boolean check){
		for(int i=0; i<buttons.length-2; i++){
			buttons[i].setEnabled(check);
			buttons[i].setFocusable(check);
		}
	}
	private void setEnabledButton_OK_clean(boolean check){
		buttons[10].setEnabled(check);
		buttons[10].setFocusable(check);
		buttons[11].setEnabled(check);
		buttons[11].setFocusable(check);
	}
}

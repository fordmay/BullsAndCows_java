package bulls_cows.engine;

import java.util.Arrays;

public class MainPrg {
	private String[] randomNumber;
	private int positionTrue = 0;
	private int numberTrue = 0;
	private boolean checkWin = false;
	
	public MainPrg(){
	}
	
	public boolean getCheckWin(){
		return checkWin;
	}
	public String getRandomNumber(){
		String number = "";
		for(int i=0; i<randomNumber.length; i++){
			number = number + randomNumber[i];
		}
		return number;
	}
	public void setRandomNumber(){
		int n = 10;
		String[] number = new String[n];
		for(int i=0; i<number.length; i++){
			number[i] = ""+i;
		}
		randomNumber = new String[4];
		for(int i=0; i<randomNumber.length; i++){
			int random =(int)(Math.random()*n);
			randomNumber[i] = number[random];
			number[random] = number[n-1];
			n--;
		}
	}
	public void setResult(String result){
		String[] massResult = new String[4];
		massResult = result.split("");
		for(int i=0; i<massResult.length; i++){
			if(massResult[i].equals(randomNumber[i])){
				positionTrue++;
			}
		}
		for(int y=0; y<massResult.length; y++){
			for(int z=0; z<randomNumber.length; z++){
				if(massResult[y].equals(randomNumber[z])){
					numberTrue++;
				}
			}
		}
		if(Arrays.equals(massResult, randomNumber)){
			checkWin = true;//Win!!!
		}
	}
	public void setResetResult(){
		positionTrue = 0;
		numberTrue = 0;

	}
	public void setResetCheckWin(){
		checkWin = false;
	}
	public String getResult(){
		return positionTrue+"/"+numberTrue;
	}
}

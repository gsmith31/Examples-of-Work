package mvc.demo.calc;

import java.util.ArrayList;

/**
 * Implements the model interface to support the ability to add new models in
 * the future. Contains the business logic for the calculator and contains no instances 
 * the controller or view. Acts as the Observable or subject in the observer pattern.
 * 
 * @author George Smith
 *
 */
public class CalcModel implements CalcModelInterface{
	
	private String displayText;
	private ArrayList<CalcObserver> observers;
	private ArrayList<Double> numbers;
	private String currentNumber;
	
	private String operator;
	
	/**
	 * No arg constructor that initializes important variables to be used
	 * through method
	 */
	public CalcModel(){
		observers = new ArrayList<CalcObserver>();
		numbers = new ArrayList<Double>();
		currentNumber = "";
		operator = "";
	}
	
	/**
	 * Setter for display text that calls notify observers so
	 * calculator can update the result
	 * 
	 * @param text String to update in the View
	 */
	public void setDisplayText(String text){
		displayText = text;
		notifyObservers();
	}
	
	/**
	 * Performs the operation by grabbing to two elements in the numbers
	 * ArrayList and uses a switch statement to determine the proper operator
	 *  
	 */
	public void performOperation(){
		Double output = 0.0;
		if(numbers.size() >= 2){
			Double firstNumber = numbers.get(0);
			Double secondNumber = numbers.get(1);
			System.out.println(firstNumber + "       " + secondNumber);
			switch (operator){
				case "+" : output = firstNumber + secondNumber;
					break;
				case "-" : output = firstNumber - secondNumber;
					break;
				case "x" : output = firstNumber * secondNumber;
					break;
				case "/" : output = firstNumber / secondNumber;
					break;
				case "" : output = Double.parseDouble(currentNumber);
					break;
			}
			numbers.clear();
			operator = "";
			numbers.add(output);
			//Catches instance when user multiples by Zero and clears elements
			if(("" + output).equalsIgnoreCase("infinity")){
				currentNumber = "";
				numbers.clear();
				setDisplayText("Infinitly Invalid");
			}else{
				setDisplayText("" + output);
			}
			
		}
	}
	
	/**
	 * Handles situations when a button representing a number is pressed
	 * and updates the view accordingly
	 * 
	 * @param buttonString String representing the number to be added to the View
	 */
	public void numericalLogic(String buttonString){
		if(operator.equalsIgnoreCase("") && numbers.size() > 0){
			numbers.clear();
		}
		if(buttonString.equalsIgnoreCase(".")){
			currentNumber += ".";
		}else{
			currentNumber += buttonString;
		}
		setDisplayText(currentNumber);
	}
	
	/**
	 * Handles situations when a non-numerical button is pressed. Assigns operator variable 
	 * the operator that was pressed or deals with logic of menu items.
	 * 
	 * @param buttonString String representing the label of the non-numerical button that was pressed
	 */
	public void operatorLogic(String buttonString){
		if(!currentNumber.equalsIgnoreCase("")){
			numbers.add(Double.parseDouble(currentNumber));
			currentNumber = "";
		}
		if(buttonString.equalsIgnoreCase("+")){
			operator = "+";
		}
		if(buttonString.equalsIgnoreCase("x")){
			operator = "x";
		}
		if(buttonString.equalsIgnoreCase("/")){
			operator = "/";
		}
		if(buttonString.equalsIgnoreCase("-")){
			operator = "-";
		}
		if(buttonString.equalsIgnoreCase("=")){
			performOperation();
		}if(buttonString.equalsIgnoreCase("clear") ){
			numbers.clear();
			operator = "";
			currentNumber = "";
			setDisplayText("0.0");
		}
		if(buttonString.equalsIgnoreCase("exit")){
			System.exit(0);
		}
	}
	
	@Override
	public void buttonClick(String buttonString) {
		if(buttonString.matches(".*\\d+.*") || buttonString.equalsIgnoreCase(".")){
			numericalLogic(buttonString);
		}else{
			operatorLogic(buttonString);
		}
	}

	@Override
	public void addObserver(CalcObserver o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(CalcObserver o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for(CalcObserver observer : observers){
			observer.update(displayText);
		}
		
	}

	

}

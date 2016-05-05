package mvc.demo.calc;

/**
 * Observer interface that all views must inherit. Contains the update method to update 
 * field with current result
 * 
 * @author George Smith
 *
 */
public interface CalcObserver {
	
	/**
	 * Observer method called by notify observers in model when there has be a state change
	 * 
	 * @param displayText String to update field
	 */
	public void update(String displayText);
	
	/**
	 * Prevents multiple decimals by disabling decimal button when last button pressed 
	 * was decimal
	 */
	public void disableDecimal();
	
	/**
	 * Enables decimal to be pressed again with a number or operator has been pressed
	 */
	public void enableDecimal();
	
	/**
	 * Displays the about JOptionPane window
	 */
	public void displayAbout();
}

package mvc.demo.calc;

/**
 * Model interface that all models must inherit. Allows future models to be created without
 * changing existing code
 * 
 * @author George Smith
 *
 */
public interface CalcModelInterface {
	
	/**
	 * Passed string the represents button label to model so the proper logic can
	 * be performed 
	 * @param buttonLabel String representing the button label
	 */
	public void buttonClick(String buttonLabel);
	
	/**
	 * Observable method to add observers
	 * 
	 * @param o Observer to be added
	 */
	public void addObserver(CalcObserver o);
	
	/**
	 * Observable method to remove observer
	 * 
	 * @param o Observer to be removed
	 */
	public void removeObserver(CalcObserver o);
	
	/**
	 * Observable method to notify all observers of important change in state
	 */
	public void notifyObservers();

}

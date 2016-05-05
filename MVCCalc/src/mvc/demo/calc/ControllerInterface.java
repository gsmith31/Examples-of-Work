package mvc.demo.calc;

/**
 * Interface all controllers must implements. Allow for future controllers to be added.
 * 
 * @author George Smith
 *
 */
public interface ControllerInterface {
	
	/**
	 * Handles events when a button or menuitem is clicked
	 * 
	 * @param button String representing the lable of the element selected
	 */
	public void onClick(String button);

}

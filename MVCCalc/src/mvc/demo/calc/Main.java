package mvc.demo.calc;

/**
 * Simple application to demonstrate the MVC design pattern that leverages
 * the observer pattern to update the view to reflect the most recent calculation.
 * 
 * Driver class to run application.
 * 
 * @author George Smith
 *
 */
public class Main {

	/**
	 * Main method to create an instance of the model and pass it to the controller
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CalcModelInterface model = new CalcModel();
		ControllerInterface controller = new CalcController(model, "Calculator");

	}

}

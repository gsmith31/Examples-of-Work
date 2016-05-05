package mvc.demo.calc;

/**
 * Controller class that inherits ControllerInterface to allow future controllers to be added
 * 
 * @author George Smith
 *
 */
public class CalcController implements ControllerInterface{
	
	private CalcModelInterface model;
	private CalcObserver view;
	
	/**
	 * Constructor that is passed an instance of the model interface and title for the view
	 * 
	 * @param model Instance of the ModelInterface
	 * @param title String representing the title of the view
	 * 
	 */
	public CalcController(CalcModelInterface model, String title){
		this.model = model;
		this.view = new CalcView(title, model, this);
	}

	@Override
	public void onClick(String label) {
		if(label.equalsIgnoreCase(".")){
			view.disableDecimal();
		}else{
			view.enableDecimal();
		}
		if(label.equalsIgnoreCase("about")){
			view.displayAbout();
		}
		model.buttonClick(label);
		
	}
	
	


}

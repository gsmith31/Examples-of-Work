package mvc.demo.calc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Acts as the observer and inherits methods from ObserverInterface. Extends
 * JFrame to serve as the UI and implements actionlistener so one actionlistener
 * is needed for entire view
 * 
 * @author George Smith
 *
 */
public class CalcView extends JFrame implements ActionListener, CalcObserver {

	private ControllerInterface controller;
	private CalcModelInterface model;

	private JMenuBar menuBar;
	private JMenu file, help;
	private JMenuItem clearItem, exit, about;

	private JTextField display;

	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
			add, sub, div, mult, clr, eql, dec;

	private JPanel top, middle, bottom;

	/**
	 * Constructor that takes the title of the view, instance of model interface
	 * and instance of the controller interface. Registers itself as an observer
	 * and builds the JFrame using several helper methods
	 * 
	 * @param title
	 *            String representing title of view
	 * @param model
	 *            Instance of model interface
	 * @param controller
	 *            Instance of controller interface
	 */
	public CalcView(String title, CalcModelInterface model,
			ControllerInterface controller) {
		super(title);
		this.model = model;
		model.addObserver(this);
		this.controller = controller;
		setLayout(new BorderLayout());
		setSize(450, 600);
		buildFrame();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		validate();
		setVisible(true);
	}

	/**
	 * Helper method to call important methods to build frame
	 */
	public void buildFrame() {
		createCalcElements();
		addElements();
	}

	/**
	 * Adds elements to parent containers and eventually populate JFrame
	 */
	public void addElements() {
		// JMenuItems
		file.add(clearItem);
		file.add(exit);
		help.add(about);

		// MenuBar
		menuBar.add(file);
		menuBar.add(help);

		// Top
		top.add(display);

		// Middle
		middle.add(btn7);
		middle.add(btn8);
		middle.add(btn9);
		middle.add(div);
		middle.add(btn4);
		middle.add(btn5);
		middle.add(btn6);
		middle.add(mult);
		middle.add(btn1);
		middle.add(btn2);
		middle.add(btn3);
		middle.add(sub);
		middle.add(dec);
		middle.add(btn0);
		middle.add(eql);
		middle.add(add);

		// Bottom
		bottom.add(clr);

		// JFrame
		setJMenuBar(menuBar);
		add(top, BorderLayout.NORTH);
		add(middle, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

	}

	/**
	 * Initializes all elements of the calculator including jButtons, JMenus,
	 * JMenuItems and adds actionlistener for each elements
	 */
	public void createCalcElements() {
		// Build JPanels
		top = new JPanel(new FlowLayout());
		middle = new JPanel(new GridLayout(4, 3));
		bottom = new JPanel(new FlowLayout());

		// Build JMenuBar
		menuBar = new JMenuBar();

		// Build JMenus
		file = new JMenu("File");
		help = new JMenu("Help");

		// Build JMenuItems
		clearItem = new JMenuItem("Clear");
		exit = new JMenuItem("Exit");
		about = new JMenuItem("About");

		// Build JTextField
		display = new JTextField("0", 20);

		// Build JButtons
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		dec = new JButton(".");
		add = new JButton("+");
		sub = new JButton("-");
		mult = new JButton("x");
		div = new JButton("/");
		eql = new JButton("=");
		clr = new JButton("Clear");

		// Add action listener
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		dec.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		eql.addActionListener(this);
		clr.addActionListener(this);

		clearItem.addActionListener(this);
		exit.addActionListener(this);
		about.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Logic that Distinguishes between jButton and JMenuItem
		try {
			controller.onClick(((JButton) (e.getSource())).getText());
		} catch (ClassCastException exc) {
			controller.onClick(((JMenuItem) (e.getSource())).getText());
		}

	}

	@Override
	public void update(String displayText) {
		display.setText(displayText);

	}

	@Override
	public void disableDecimal() {
		dec.setEnabled(false);

	}

	@Override
	public void enableDecimal() {
		dec.setEnabled(true);

	}

	@Override
	public void displayAbout() {
		JFrame frame = new JFrame();
		JOptionPane
				.showMessageDialog(
						frame,
						"Simple Calculator to demonstrate the MVC design pattern "
								+ "as well as the observer pattern to update the text field.",
						"About", JOptionPane.INFORMATION_MESSAGE);

	}

}

package controller;

import model.UnitConverter;
import view.ConverterUI;

/**
 * A main class to create objects and run the program.
 * 
 * @author Patinya Yongyai
 *
 */
public class Main {

	/**
	 * Main application for create ConverterUI.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		UnitConverter uc = new UnitConverter();
		ConverterUI convertUI = new ConverterUI(uc);
		convertUI.run();
	}
}

package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Length;
import model.UnitConverter;

/**
 * 	User interface of Unit Converter.
 * 
 * @author Patinya Yongyai
 *
 */
public class ConverterUI extends JFrame {
	private JButton convertButton;
	private JButton clearButton;
	private JTextField inputTextField;
	private JTextField resultTextField;
	private JComboBox<Length> unit1ComboBox;
	private JComboBox<Length> unit2ComboBox;
	private JLabel equalLabel;
	private UnitConverter unitconverter;
	private JRadioButton leftToRight;
	private JRadioButton rightToLeft;

	/**
	 * Initialize user interface.
	 * 
	 * @param uc
	 *            is UnitConverter
	 */
	public ConverterUI(UnitConverter uc) {
		this.unitconverter = uc;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	/**
	 * Initialize components in the window
	 */
	public void initComponents() {
		Panel innerLine1 = new Panel();
		Panel innerLine2 = new Panel();
		Panel outer = new Panel();

		convertButton = new JButton("Convert!");
		clearButton = new JButton("Clear");
		equalLabel = new JLabel("=");
		inputTextField = new JTextField(8);
		resultTextField = new JTextField(8);
		resultTextField.setEditable(false);
		unit1ComboBox = new JComboBox<Length>(Length.values());
		unit2ComboBox = new JComboBox<Length>(Length.values());
		leftToRight = new JRadioButton("Left->Right");
		leftToRight.setSelected(true);
		rightToLeft = new JRadioButton("Right->Left");
		FlowLayout flowLayout = new FlowLayout();
		BorderLayout borderLayout = new BorderLayout();
		innerLine1.setLayout(flowLayout);
		innerLine1.add(inputTextField);
		innerLine1.add(unit1ComboBox);
		innerLine1.add(equalLabel);
		innerLine1.add(resultTextField);
		innerLine1.add(unit2ComboBox);
		innerLine1.add(convertButton);
		innerLine1.add(clearButton);

		innerLine2.setLayout(flowLayout);
		innerLine2.add(leftToRight);
		innerLine2.add(rightToLeft);

		outer.setLayout(borderLayout);
		outer.add(innerLine1, BorderLayout.NORTH);
		outer.add(innerLine2, BorderLayout.CENTER);

		convertButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!resultTextField.isEditable()) {
					resultTextField.setText(unitconverter.convert(Double.parseDouble(inputTextField.getText().trim()),
							unit1ComboBox.getItemAt(unit1ComboBox.getSelectedIndex()),
							unit2ComboBox.getItemAt(unit2ComboBox.getSelectedIndex())) + "");
				}
				inputTextField.setText(unitconverter.convert(Double.parseDouble(resultTextField.getText().trim()),
						unit2ComboBox.getItemAt(unit2ComboBox.getSelectedIndex()),
						unit1ComboBox.getItemAt(unit1ComboBox.getSelectedIndex())) + "");
			}
		});

		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputTextField.setText("");
				resultTextField.setText("");
			}
		});

		leftToRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rightToLeft.setSelected(false);
				inputTextField.setEditable(true);
				resultTextField.setEditable(false);
			}
		});

		rightToLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				leftToRight.setSelected(false);
				inputTextField.setEditable(false);
				resultTextField.setEditable(true);
			}
		});

		inputTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				convertButton.doClick();
			}
		});

		resultTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				convertButton.doClick();
			}
		});

		this.add(outer);
		this.pack();
	}

	/**
	 * Show user interface.
	 */
	public void run() {
		this.setVisible(true);
	}
}

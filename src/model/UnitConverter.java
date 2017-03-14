package model;

/**
 * The UnitConverter class receives requests from the UI to converts a value
 * from one unit to another.
 * 
 * @author Patinya Yongyai
 *
 */
public class UnitConverter {
	/**
	 * 
	 * @param amount
	 *            Value of unit that want to convert
	 * @param fromUnit
	 *            Current unit that want to convert
	 * @param toUnit
	 *            Result unit that want to convert
	 * @return result from convertx
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		return (amount * fromUnit.getValue()) / toUnit.getValue();
	}

	/**
	 * Get all units of length.
	 * 
	 * @return all units of length
	 */
	public Unit[] getUnits() {
		return Length.values();
	}
}

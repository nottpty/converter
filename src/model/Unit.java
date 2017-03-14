package model;

/**
 * Provides behavior of all units.
 * 
 * @author Patinya Yongyai
 *
 */
public interface Unit {
	/**
	 * Get the of value of unit
	 * 
	 * @return value of unit
	 */
	public double getValue();

	/**
	 * Get the name for the unit.
	 * 
	 * @return name for the unit.
	 */
	public String toString();
}

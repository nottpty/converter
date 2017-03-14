package model;

/**
 * A definition of common units of length.
 * 
 * @author Patinya Yongyai
 *
 */
public enum Length implements Unit{
	/* Define the members of the enumeration
	 * The attributes are:
	 * name = a string name for this unit,
	 * value = multiplier to convert to meters.
	 */
	METER( "Meter",1.00 ),
	MILE( "Mile",1609.344 ),
	KILOMETER( "Kilometer",1000.0 ),
	CENTIMETER( "Centimeter",0.01 ),
	FOOT( "Foot",0.30480 ),
	WA( "Wa",2.0 ),
	INCH( "Inch",0.0254 ),
	YARD( "Yard",3*(0.30480) ),
	MICRON( "Micron",1.0E-6 );
	
	/** name of this unit */
	private final String name;
	/** multiplier to convert this unit to std unit */
	private final double value;

	/** Private constructor for enum members */
	Length(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/** the of value of unit */
	@Override
	public double getValue() {
		return value;
	}
	
	/** name for the unit. */
	public String toString() {
		return name;
	}
}

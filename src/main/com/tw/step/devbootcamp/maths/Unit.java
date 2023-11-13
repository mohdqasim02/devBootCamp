package com.tw.step.devbootcamp.maths;

public enum Unit {
	FEET(12.0, 0.0, UnitType.LENGTH),
	INCH(1.0, 0.0, UnitType.LENGTH),
	CM(0.39, 0.0, UnitType.LENGTH),
	MM(0.039, 0.0, UnitType.LENGTH),
	GALLON(3.78, 0.0, UnitType.VOLUME),
	LITER(1.0, 0.0, UnitType.VOLUME),
	CELSIUS(1.8, 32.0, UnitType.TEMPERATURE),
	FAHRENHEIT(1.0,0.0, UnitType.TEMPERATURE);

	private final UnitType type;
	private final double gradient;
	private final double intercept;

	Unit(Double gradient, Double intercept, UnitType type) {
		this.type = type;
		this.gradient = gradient;
		this.intercept = intercept;
	}

	public double toStandard(double value) {
		return value * this.gradient + this.intercept;
	}

	boolean isOfSameType(Unit other) {
		return this.type == other.type;
	}


	public Unit getStandardUnit() {
		System.out.println(this.type.getStandard());
		return this.type.getStandard();
	}
}

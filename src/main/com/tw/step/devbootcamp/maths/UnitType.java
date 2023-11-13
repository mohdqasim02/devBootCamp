package com.tw.step.devbootcamp.maths;

public enum UnitType {
	LENGTH(Unit.INCH),
	VOLUME(Unit.LITER),
	TEMPERATURE(Unit.FAHRENHEIT);

	private final Unit standard;

	UnitType(Unit standard) {
		this.standard = standard;
	}

	public Unit getStandard() {
		return this.standard;
	}
}

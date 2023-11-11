package com.tw.step.devbootcamp.maths;

import java.util.HashSet;

public enum Unit {
	FEET (12, UnitType.LENGTH),
	INCH (1, UnitType.LENGTH),
	CM (0.39, UnitType.LENGTH),
	MM (0.039, UnitType.LENGTH),
	GALLON(3.78, UnitType.VOLUME),
	LITER(1, UnitType.VOLUME);

	private final double conversionFactor;
	private final UnitType type;

	Unit(double conversionFactor, UnitType type) {
		this.type = type;
		this.conversionFactor = conversionFactor;
	}

	public double toStandard(double value) {
		return this.conversionFactor * value;
	}

	boolean isOfSameType(Unit other) {
		return this.type == other.type;
	}
}

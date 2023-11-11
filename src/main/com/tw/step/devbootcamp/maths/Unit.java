package com.tw.step.devbootcamp.maths;

public enum Unit {
	FEET (30.48),
	INCH (2.54),
	CM (1),
	MM (0.1);

	private final double conversionFactor;

	Unit(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public double toStandard(double value) {
		return this.conversionFactor * value;
	}
}

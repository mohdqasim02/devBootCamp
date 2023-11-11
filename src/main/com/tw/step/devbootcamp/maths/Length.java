package com.tw.step.devbootcamp.maths;

import com.tw.step.devbootcamp.maths.exceptions.InvalidLenghtException;

public class Length implements Comparable<Length> {
	private final Unit unit;
	private final double value;

	private Length(double value, Unit unit) {
		this.unit = unit;
		this.value = value;
	}

	public static Length of(double value, Unit unit) throws InvalidLenghtException {
		if(value < 0) throw new InvalidLenghtException(value);
		return new Length(value, unit);
	}

	private double toStandard() {
		return this.unit.toStandard(this.value);
	}

	@Override
	public int compareTo(Length other) {
		return Double.compare(this.toStandard(), other.toStandard());
	}
}

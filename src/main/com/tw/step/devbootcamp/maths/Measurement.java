package com.tw.step.devbootcamp.maths;

import com.tw.step.devbootcamp.maths.exceptions.InvalidLenghtException;

public class Measurement implements Comparable<Measurement> {
	private final Unit unit;
	private final double value;

	private Measurement(double value, Unit unit) {
		this.unit = unit;
		this.value = value;
	}

	public static Measurement of(double value, Unit unit) throws InvalidLenghtException {
		if(value < 0) throw new InvalidLenghtException(value);
		return new Measurement(value, unit);
	}

	private double toStandard() {
		return this.unit.toStandard(this.value);
	}

	@Override
	public int compareTo(Measurement other) {
		return Double.compare(this.toStandard(), other.toStandard());
	}
}

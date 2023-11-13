package com.tw.step.devbootcamp.maths;

import com.tw.step.devbootcamp.maths.exceptions.IncompatibleUnitException;
import com.tw.step.devbootcamp.maths.exceptions.InvalidLenghtException;

import java.util.Objects;

public class Measurement{
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

	public int compare(Measurement other) throws IncompatibleUnitException {
		if(!this.unit.isOfSameType(other.unit)) throw new IncompatibleUnitException(this.unit, other.unit);
		return Double.compare(this.toStandard(), other.toStandard());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Measurement that = (Measurement) o;
		return Double.compare(this.value, that.value) == 0 && this.unit == that.unit;
	}

	@Override
	public String toString() {
		return String.format("Measurement{unit=%s, value=%s}", this.unit, this.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.unit, this.value);
	}

	private Measurement add(Measurement other, Unit standard) throws InvalidLenghtException, IncompatibleUnitException {
		if(!this.unit.isOfSameType(other.unit)) {
			throw new IncompatibleUnitException(this.unit, other.unit);
		}

		return Measurement.of(this.roundUpToThreeDecimal(this.toStandard() + other.toStandard()), standard);
	}

	private double roundUpToThreeDecimal(double number) {
		return (double) Math.round(number * 1000) / 1000.0;
	}

	public Measurement addLength(Measurement other) throws IncompatibleUnitException, InvalidLenghtException {
		return this.add(other, Unit.INCH);
	}

	public Measurement addVolume(Measurement other) throws IncompatibleUnitException, InvalidLenghtException {
		return this.add(other, Unit.LITER);
	}
}

package com.tw.step.devbootcamp.maths;

import com.tw.step.devbootcamp.maths.exceptions.InvalidChanceException;

import java.util.Objects;

public class Chance {
	private final double ratio;

	private Chance(double ratio) {
		this.ratio = ratio;
	}

	public static Chance of(double ratio) throws InvalidChanceException {
		if(ratio < 0 || ratio > 1) throw new InvalidChanceException(ratio);
		return new Chance(ratio);
	}

	public Chance inverse() throws InvalidChanceException {
		return Chance.of(1 - this.ratio);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Chance chance = (Chance) o;
		return Double.compare(this.ratio, chance.ratio) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.ratio);
	}

	public Chance and(Chance otherChance) throws InvalidChanceException {
		return Chance.of(this.ratio * otherChance.ratio);
	}

	@Override
	public String toString() {
		return String.format("Chance{ratio=%s}", this.ratio);
	}

	public Chance or(Chance other) throws InvalidChanceException {
		double ratioOfThisOrOther = this.ratio + other.ratio - this.and(other).ratio;
		return Chance.of(ratioOfThisOrOther);
	}
}

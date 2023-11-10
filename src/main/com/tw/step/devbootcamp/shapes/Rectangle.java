package com.tw.step.devbootcamp.shapes;

import com.tw.step.devbootcamp.shapes.exceptions.InvalidDimensionException;

public class Rectangle implements TwoDimensionalShape{
	private final int length;
	private final int width;

	protected Rectangle(int length, int width) {
		this.width = width;
		this.length = length;
	}

	@Override
	public int area() {
		return this.length * this.width;
	}

	@Override
	public int perimeter() {
		return 2 * (this.length + this.width);
	}

	public static Rectangle create(int length, int width) throws InvalidDimensionException {
		if(length <= 0 || width <= 0) throw new InvalidDimensionException(length, width);
		return new Rectangle(length, width);
	}
}

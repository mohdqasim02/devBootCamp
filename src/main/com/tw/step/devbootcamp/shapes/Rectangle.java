package com.tw.step.devbootcamp.shapes;

import com.tw.step.devbootcamp.shapes.exceptions.InvalidDimensionException;

public class Rectangle implements TwoDimensionalShape{
	private final double length;
	private final double width;

	private Rectangle(double length, double width) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double area() {
		return this.length * this.width;
	}

	@Override
	public double perimeter() {
		return 2 * (this.length + this.width);
	}

	public static Rectangle create(int length, int width) throws InvalidDimensionException {
		if(length <= 0 || width <= 0) throw new InvalidDimensionException(length, width);
		return new Rectangle(length, width);
	}

	public static Rectangle createSquare(int side) throws InvalidDimensionException {
		return Rectangle.create(side, side);
	}
}

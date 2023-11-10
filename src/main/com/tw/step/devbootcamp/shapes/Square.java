package com.tw.step.devbootcamp.shapes;

import com.tw.step.devbootcamp.shapes.exceptions.InvalidDimensionException;

public class Square extends Rectangle {
	private Square(int side) {
		super(side, side);
	}

	public static Square create(int side) throws InvalidDimensionException {
		if(side <= 0) throw new InvalidDimensionException(side);
		return new Square(side);
	}
}

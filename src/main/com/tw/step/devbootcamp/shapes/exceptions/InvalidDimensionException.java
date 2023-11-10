package com.tw.step.devbootcamp.shapes.exceptions;

public class InvalidDimensionException extends Throwable {
	public InvalidDimensionException(int length, int width) {
		super("Invalid length: " + length + "\nwidth: " + width);
	}
}

package com.tw.step.devbootcamp.maths.exceptions;

public class InvalidChanceException extends Throwable {
	public InvalidChanceException(double ratio) {
		super("Out of range: " + ratio);
	}
}

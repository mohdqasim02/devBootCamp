package com.tw.step.devbootcamp.maths.exceptions;

public class InvalidLenghtException extends Throwable {
	public InvalidLenghtException(double value) {
		super("Invalid Length: " + value);
	}
}

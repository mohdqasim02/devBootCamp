package com.tw.step.devbootcamp.maths.exceptions;

import com.tw.step.devbootcamp.maths.Unit;

public class IncompatibleUnitException extends Throwable {
	public IncompatibleUnitException(Unit first, Unit second) {
		super("Two units are incompatible: " + first + " and " + second);
	}
}

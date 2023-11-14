package com.tw.step.devbootcamp.carparking.exceptions;

public class ParkingLotFullException extends Throwable {
	public ParkingLotFullException() {
		super("Out of space");
	}
}

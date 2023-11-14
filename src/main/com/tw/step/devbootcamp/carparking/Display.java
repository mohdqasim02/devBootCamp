package com.tw.step.devbootcamp.carparking;

import java.io.PrintStream;
import java.util.Arrays;

public class Display {
	private final PrintStream out;

	public Display(PrintStream out) {
		this.out = out;
	}

	public void show(ParkingLot[] parkingLots) {
		this.out.println(Arrays.toString(parkingLots));
	}
}

package com.tw.step.devbootcamp.carparking;

public class Assistant {
	private final Display display;

	public Assistant(Display display) {
		this.display = display;
	}

	public void monitor(ParkingLot ...parkingLots) {
		this.display.show(parkingLots);
	}
}

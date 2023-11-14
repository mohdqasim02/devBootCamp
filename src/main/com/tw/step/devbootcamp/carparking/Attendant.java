package com.tw.step.devbootcamp.carparking;

import com.tw.step.devbootcamp.carparking.exceptions.ParkingLotFullException;

import java.util.ArrayList;

public class Attendant implements ParkingLotFullObserver {
	private final ArrayList<ParkingLot> parkingLots;
	private Assistant assistant;

	public Attendant() {
		this.assistant = null;
		this.parkingLots = new ArrayList<>();
	}

	public void assignParkingLot(ParkingLot parkingLot) {
		this.parkingLots.add(parkingLot);
		parkingLot.notifyOnFull(this);
	}

	public void assignAssistant(Assistant assistant) {
		this.assistant = assistant;
	}

	public void onFull() {
		System.out.println("Parking lot is full");
	}

	public boolean isParked(Car car) {
		return this.parkingLots.stream().anyMatch(parkingLot -> parkingLot.isParked(car));
	}

	public void park(Car car) throws ParkingLotFullException {
		if (this.isParkingLotsFull()) throw new ParkingLotFullException();

		for (ParkingLot parkingLot : this.parkingLots) {
			if (!parkingLot.isFull()) {
				parkingLot.add(car);
				return;
			}
		}
	}

	private boolean isParkingLotsFull() {
		return this.parkingLots.stream().allMatch(ParkingLot::isFull);
	}
}

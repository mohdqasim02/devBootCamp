package com.tw.step.devbootcamp.carparking;

import java.util.ArrayList;

public class ParkingLot {
	private final int totalCapacity;
	private final ArrayList<Car> parkingLot;
	private final ArrayList<ParkingLotFullObserver> parkingLotObservers;

	public ParkingLot(int totalCapacity) {
		this.parkingLot = new ArrayList<>();
		this.parkingLotObservers = new ArrayList<>();
		this.totalCapacity = totalCapacity;
	}

	public void notifyOnFull(ParkingLotFullObserver observer) {
		this.parkingLotObservers.add(observer);
	}

	public boolean isParked(Car car) {
		return this.parkingLot.contains(car);
	}

	public void add(Car car) {
		this.parkingLot.add(car);

		if (this.isFull()) this.parkingLotObservers.forEach(ParkingLotFullObserver::onFull);
	}

	public boolean isFull() {
		return this.totalCapacity == this.parkingLot.size();
	}

	public boolean is80percentFull() {
		return this.parkingLot.size() / this.totalCapacity * 100 >= 80;
	}
}

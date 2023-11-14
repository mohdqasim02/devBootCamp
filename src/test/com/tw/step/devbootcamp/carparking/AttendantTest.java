package com.tw.step.devbootcamp.carparking;

import com.tw.step.devbootcamp.carparking.exceptions.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttendantTest {
	@Test
	void shouldParkCarInTheParkingLot() throws ParkingLotFullException {
		ParkingLot parkingLot = new ParkingLot(50);
		Attendant attendant = new Attendant();
		attendant.assignParkingLot(parkingLot);
		Car alto = new Car("alto800");

		attendant.park(alto);
		assertTrue(attendant.isParked(alto));
	}

	@Test
	void shouldNotParkIfTheParkingIsFull() throws ParkingLotFullException {
		ParkingLot parkingLot = new ParkingLot(1);
		Attendant attendant = new Attendant();
		attendant.assignParkingLot(parkingLot);

		Car mercedes = new Car("m1mercedes");
		Car alto = new Car("alto800");

		attendant.park(mercedes);

		assertThrows(ParkingLotFullException.class, () -> attendant.park(alto));
	}

	@Test
	void shouldParkACarInAnAvailableParkingLot() throws ParkingLotFullException {
		ParkingLot parkingLot1 = new ParkingLot(1);
		ParkingLot parkingLot2 = new ParkingLot(1);
		Attendant attendant = new Attendant();

		attendant.assignParkingLot(parkingLot1);
		attendant.assignParkingLot(parkingLot2);

		Car mercedes = new Car("m1mercedes");
		Car alto = new Car("alto800");

		attendant.park(mercedes);
		attendant.park(alto);

		assertThrows(ParkingLotFullException.class, () -> attendant.park(alto));
	}
}
package com.tw.step.devbootcamp.carparking;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ParkingLotTest {
	@Test
	void shouldInformParkingLotObserversOnFull() {
		ParkingLot parkingLot = new ParkingLot(1);
		ParkingLotFullObserver observer = mock(ParkingLotFullObserver.class);
		doNothing().when(observer).onFull();

		parkingLot.notifyOnFull(observer);
		parkingLot.add(new Car("alto800"));

		verify(observer).onFull();
	}
}
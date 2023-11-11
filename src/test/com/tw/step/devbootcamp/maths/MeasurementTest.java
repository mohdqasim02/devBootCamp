package com.tw.step.devbootcamp.maths;

import com.tw.step.devbootcamp.maths.exceptions.IncompatibleUnitException;
import com.tw.step.devbootcamp.maths.exceptions.InvalidLenghtException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
	@Test
	void shouldNotCreateLengthOfNegativeValue() {
		assertThrows(InvalidLenghtException.class, () -> Measurement.of(-2, null));
	}

	@Test
	void shouldCompareFeetAndInches() throws InvalidLenghtException {
		Measurement _1Feet = Measurement.of(1, Unit.FEET);
		Measurement _12Inch = Measurement.of(12, Unit.INCH);

		assertEquals(0, _1Feet.compareTo(_12Inch));
	}

	@Test
	void shouldCompareInchesAndCentimeter() throws InvalidLenghtException {
		Measurement fiveCentiMeter = Measurement.of(5, Unit.CM);
		Measurement twoInches = Measurement.of(2, Unit.INCH);

		assertEquals(-1, fiveCentiMeter.compareTo(twoInches));
	}

	@Test
	void shouldCompareCentimeterAndMillimeter() throws InvalidLenghtException {
		Measurement oneCentiMeter = Measurement.of(1, Unit.CM);
		Measurement tenMilliMeter = Measurement.of(10, Unit.MM);

		assertEquals(0, oneCentiMeter.compareTo(tenMilliMeter));
	}

	@Test
	void shouldCompareVolumesInLitersAndGallons() throws InvalidLenghtException {
		Measurement oneGallon = Measurement.of(1, Unit.GALLON);
		Measurement fourLiters = Measurement.of(4, Unit.LITER);

		assertEquals(-1, oneGallon.compareTo(fourLiters));
	}

	@Test
	void shouldAddTwoMeasurementsOfSameUnit() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement twoInch = Measurement.of(2, Unit.INCH);

		assertEquals(Measurement.of(4, Unit.INCH), twoInch.addLength(twoInch));
	}

	@Test
	void shouldAddTwoMeasurementsOfSameType() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement twoInch = Measurement.of(2, Unit.INCH);
		Measurement twoCentiMeter = Measurement.of(2.5, Unit.CM);

		assertEquals(Measurement.of(2.975, Unit.INCH), twoInch.addLength(twoCentiMeter));
	}

	@Test
	void shouldAddTwoMeasurementsVolumeType() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement oneLiter = Measurement.of(1, Unit.LITER);
		Measurement oneGallon = Measurement.of(1, Unit.GALLON);

		assertEquals(Measurement.of(4.779999999999999, Unit.LITER), oneLiter.addVolume(oneGallon));
	}

	@Test
	void shouldNotAddMeasurementOfTwoDifferentUnits() throws InvalidLenghtException {
		Measurement twoInch = Measurement.of(2, Unit.INCH);
		Measurement twoLiters = Measurement.of(2, Unit.LITER);

		assertThrows(IncompatibleUnitException.class, () -> twoInch.addLength(twoLiters));
	}
}
package com.tw.step.devbootcamp.maths;

import com.tw.step.devbootcamp.maths.exceptions.IncompatibleUnitException;
import com.tw.step.devbootcamp.maths.exceptions.InvalidLenghtException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class MeasurementTest {
	@Test
	void shouldNotCreateLengthOfNegativeValue() {
		assertThrows(InvalidLenghtException.class, () -> Measurement.of(-2, null));
	}

	@Test
	void shouldCompareFeetAndInches() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement _1Feet = Measurement.of(1, Unit.FEET);
		Measurement _12Inch = Measurement.of(12, Unit.INCH);

		assertEquals(0, _1Feet.compare(_12Inch));
	}

	@Test
	void shouldCompareInchesAndCentimeter() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement fiveCentiMeter = Measurement.of(5, Unit.CM);
		Measurement twoInches = Measurement.of(2, Unit.INCH);

		assertEquals(-1, fiveCentiMeter.compare(twoInches));
	}

	@Test
	void shouldCompareCentimeterAndMillimeter() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement oneCentiMeter = Measurement.of(1, Unit.CM);
		Measurement tenMilliMeter = Measurement.of(10, Unit.MM);

		assertEquals(0, oneCentiMeter.compare(tenMilliMeter));
	}

	@Test
	void shouldCompareVolumesInLitersAndGallons() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement oneGallon = Measurement.of(1, Unit.GALLON);
		Measurement fourLiters = Measurement.of(4, Unit.LITER);

		assertEquals(-1, oneGallon.compare(fourLiters));
	}

	@Test
	void shouldAddTwoMeasurementsOfSameUnit() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement twoInch = Measurement.of(2, Unit.INCH);

		assertEquals(Measurement.of(4, Unit.INCH), twoInch.add(twoInch));
	}

	@Test
	void shouldAddTwoMeasurementsOfSameType() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement twoInch = Measurement.of(2, Unit.INCH);
		Measurement twoCentiMeter = Measurement.of(2.5, Unit.CM);

		assertEquals(Measurement.of(2.975, Unit.INCH), twoInch.add(twoCentiMeter));
	}

	@Test
	@Disabled
	void shouldAddTwoMeasurementsVolumeType() throws InvalidLenghtException, IncompatibleUnitException {
		Measurement oneLiter = Measurement.of(1, Unit.LITER);
		Measurement oneGallon = Measurement.of(1, Unit.GALLON);

		assertEquals(Measurement.of(4.78, Unit.LITER), oneLiter.add(oneGallon));
	}

	@Test
	void shouldNotAddMeasurementOfTwoDifferentUnits() throws InvalidLenghtException {
		Measurement twoInch = Measurement.of(2, Unit.INCH);
		Measurement twoLiters = Measurement.of(2, Unit.LITER);

		assertThrows(IncompatibleUnitException.class, () -> twoInch.add(twoLiters));
	}

	@Test
	void shouldNotCompareMeasurementOfTwoDifferentUnits() throws InvalidLenghtException {
		Measurement twoInch = Measurement.of(2, Unit.INCH);
		Measurement twoLiters = Measurement.of(2, Unit.LITER);

		assertThrows(IncompatibleUnitException.class, () -> twoInch.compare(twoLiters));
	}

	@Test
	void shouldCompareTemperatureInCelsiusAndFahrenheit() throws IncompatibleUnitException, InvalidLenghtException {
		Measurement twoOnetwoFahrenheit = Measurement.of(212, Unit.FAHRENHEIT);
		Measurement hundredCelsius = Measurement.of(100, Unit.CELSIUS);

		assertEquals(0, twoOnetwoFahrenheit.compare(hundredCelsius));
	}

	@Test
	void shouldCompareTemperatureInFahrenheit() throws IncompatibleUnitException, InvalidLenghtException {
		Measurement _212Fahrenheit = Measurement.of(212, Unit.FAHRENHEIT);
		Measurement hundredFahrenheit = Measurement.of(100, Unit.FAHRENHEIT);

		assertEquals(1, _212Fahrenheit.compare(hundredFahrenheit));
	}
}
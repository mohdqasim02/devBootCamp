package com.tw.step.devbootcamp.maths;

import com.tw.step.devbootcamp.maths.exceptions.InvalidLenghtException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
	@Test
	void shouldNotCreateLengthOfNegativeValue() {
		assertThrows(InvalidLenghtException.class, () -> Length.of(-2, null));
	}

	@Test
	void shouldCompareFeetAndInches() throws InvalidLenghtException {
		Length _1Feet = Length.of(1, Unit.FEET);
		Length _12Inch = Length.of(12, Unit.INCH);

		assertEquals(0, _1Feet.compareTo(_12Inch));
	}

	@Test
	void shouldCompareInchesAndCentimeter() throws InvalidLenghtException {
		Length fiveCentiMeter = Length.of(5, Unit.CM);
		Length twoInches = Length.of(2, Unit.INCH);

		assertEquals(-1, fiveCentiMeter.compareTo(twoInches));
	}

	@Test
	void shouldCompareCentimeterAndMillimeter() throws InvalidLenghtException {
		Length oneCentiMeter = Length.of(1, Unit.CM);
		Length tenMilliMeter = Length.of(10, Unit.MM);

		assertEquals(0, oneCentiMeter.compareTo(tenMilliMeter));
	}
}
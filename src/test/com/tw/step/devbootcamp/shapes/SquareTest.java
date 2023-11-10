package com.tw.step.devbootcamp.shapes;

import com.tw.step.devbootcamp.shapes.exceptions.InvalidDimensionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
	@Test
	void shouldCalculateAreaOfTheSquare() throws InvalidDimensionException {
		Square square = Square.create(5);

		assertEquals(25, square.area());
	}

	@Test
	void shouldCalculatePerimeterOfTheSquare() throws InvalidDimensionException {
		Square square = Square.create(5);

		assertEquals(20, square.perimeter());
	}

	@Test
	void shouldNotCreateSquareForSideLessThanZero() {
		assertThrows(InvalidDimensionException.class, () -> Square.create(-5));
	}

	@Test
	void shouldNotCreateSquareForSideEqualToZero() {
		assertThrows(InvalidDimensionException.class, () -> Square.create(0));
	}
}

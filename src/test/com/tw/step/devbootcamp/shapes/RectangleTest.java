package com.tw.step.devbootcamp.shapes;

import com.tw.step.devbootcamp.shapes.exceptions.InvalidDimensionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
	@Test
	void shouldCalculateAreaOfTheRectangle() throws InvalidDimensionException {
		Rectangle rectangle = Rectangle.create(5, 6);

		assertEquals(30, rectangle.area());
	}

	@Test
	void shouldCalculatePerimeterOfTheRectangle() throws InvalidDimensionException {
		Rectangle rectangle1 = Rectangle.create(5, 4);

		assertEquals(18, rectangle1.perimeter());
	}

	@Test
	void shouldNotCreateRectangleForSideLessThanZero() {
		assertThrows(InvalidDimensionException.class, () -> Rectangle.create(-5, 8));
	}

	@Test
	void shouldNotCreateRectangleForSideEqualToZero() {
		assertThrows(InvalidDimensionException.class, () -> Rectangle.create(0, 7));
	}

	@Test
	void shouldCalculateAreaOfTheSquare() throws InvalidDimensionException {
		Rectangle square = Rectangle.createSquare(5);

		assertEquals(25, square.area());
	}

	@Test
	void shouldCalculatePerimeterOfTheSquare() throws InvalidDimensionException {
		Rectangle square = Rectangle.createSquare(5);

		assertEquals(20, square.perimeter());
	}

	@Test
	void shouldNotCreateSquareForSideLessThanZero() {
		assertThrows(InvalidDimensionException.class, () -> Rectangle.createSquare(-5));
	}

	@Test
	void shouldNotCreateSquareForSideEqualToZero() {
		assertThrows(InvalidDimensionException.class, () -> Rectangle.createSquare(0));
	}
}
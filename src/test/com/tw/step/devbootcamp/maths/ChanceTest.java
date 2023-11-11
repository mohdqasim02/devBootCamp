package com.tw.step.devbootcamp.maths;

import com.tw.step.devbootcamp.maths.exceptions.InvalidChanceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

	@Test
	void shouldNotCreateChanceWhenRatioIsGreaterThanOne(){
		assertThrows(InvalidChanceException.class, () -> Chance.of(2));
	}

	@Test
	void shouldNotCreateChanceWhenRatioIsLessThanZero(){
		assertThrows(InvalidChanceException.class, () -> Chance.of(-2));
	}

	@Test
	void shouldCalculateTheChanceOfNotGettingTail() throws InvalidChanceException {
		Chance gettingTail = Chance.of(0.5);
		Chance notGettingTail = gettingTail.not();

		assertEquals(notGettingTail, gettingTail);
	}

	@Test
	void shouldCalculateChanceForGettingTailInTwoCoins() throws InvalidChanceException {
		Chance gettingTail = Chance.of(0.5);
		Chance gettingTailInTwoCoins = gettingTail.and(gettingTail);

		assertEquals(gettingTailInTwoCoins, Chance.of(0.25));
	}

	@Test
	void shouldCalculateChanceForGettingAtLeastOneTails() throws InvalidChanceException {
		Chance gettingTail = Chance.of(0.5);
		Chance gettingAtLeastOneTailInTwoCoin = gettingTail.or(gettingTail);

		assertEquals(gettingAtLeastOneTailInTwoCoin, Chance.of(0.75));
	}
}
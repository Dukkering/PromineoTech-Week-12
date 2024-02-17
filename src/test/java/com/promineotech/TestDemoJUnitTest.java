package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@Test
	void assertThatTwoPositiveNumbersAreAddedCorrectly() {

		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(500, 600)).isEqualTo(1100);

	}

	// Given: two strings

	// When: provided as for the test

	// Then: the strings are concacted together with a space in the middle

	@Test
	void assertThatTwoStringsConcactCorrectly() {
		assertThat(testDemo.concactStrings("Hello", "Goodbye")).isEqualTo("Hello Goodbye");
		assertThat(testDemo.concactStrings("Yippie Kai Yay,", "motherfucka!"))
				.isEqualTo("Yippie Kai Yay, motherfucka!");
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
		arguments(2, 4, 6, false),
		arguments(0, 2, 0, true),
		arguments(10, 20, 30, false),
		arguments(2, 0, 0, true),
		arguments(-2, 10, 0, true),
		arguments(-2, -4, 0, true),
		arguments(5, -20, 0, true),
		arguments(5000, 1, 5001, false)
		);
		//@formatter:on
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}

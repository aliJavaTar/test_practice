package org.travel;

import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;

import static org.assertj.core.api.Assertions.assertThat;

class OddShould {

    @Property(generation = GenerationMode.EXHAUSTIVE)
    @Report(Reporting.GENERATED)
    public void give_odd_number_return_true(@ForAll("oddNumbers") int value) {
        Odd odd = new Odd(value);
        assertThat(odd.isOdd()).isTrue();
    }

    @Property
    public void give_even_number_return_false(@ForAll("evenNumbers") int value) {
        Odd odd = new Odd(value);
        assertThat(odd.isOdd()).isFalse();
    }

    @Provide
    Arbitrary<Integer> oddNumbers() {
        return Arbitraries.integers().filter(n -> n % 2 != 0);
    }

    @Provide
    Arbitrary<Integer> evenNumbers() {
        return Arbitraries.integers().filter(n -> n % 2 == 0);
    }

//    private static Stream<Arguments> provideIntegerInputs() {
//        return Stream.of(
//                Arguments.arguments(2, false),
//                Arguments.arguments(12, false),
//                Arguments.arguments(3, true),
//                Arguments.arguments(21, true)
//        );
//    }//    @ParameterizedTest
//    @MethodSource("provideIntegerInputs")
//    void give_number_and_if_be_odd_true(int inputNumber, boolean expect) {
//        Odd odd = new Odd(inputNumber);
//        assertThat(odd.isOdd()).isEqualTo(expect);
//    }
}
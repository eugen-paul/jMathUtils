package net.eugenpaul.mathutils.primenumber;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class PrimeNumberGenTest {

    @Test
    void test_GenPrimeNumbers_to_1() {
        List<Long> primeNumbers = List.of(1L);
        List<Long> genPrimeNumbers = PrimeNumberGen.genPrimeNumbers(1);

        assertArrayEquals(primeNumbers.toArray(), genPrimeNumbers.toArray());
    }

    @Test
    void test_GenPrimeNumbers_to_2() {
        List<Long> primeNumbers = List.of(1L, 2L);
        List<Long> genPrimeNumbers = PrimeNumberGen.genPrimeNumbers(2);

        assertArrayEquals(primeNumbers.toArray(), genPrimeNumbers.toArray());
    }

    @Test
    void test_GenPrimeNumbers_to_100() {
        List<Long> primeNumbers = List.of(1L, 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L,
                53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L);
        List<Long> genPrimeNumbers = PrimeNumberGen.genPrimeNumbers(100);

        assertArrayEquals(primeNumbers.toArray(), genPrimeNumbers.toArray());
    }

    @Test
    void test_GenPrimeNumbers_Exception() {
        assertThrows(IllegalArgumentException.class, () -> PrimeNumberGen.genPrimeNumbers(0));
    }

    @Test
    void test_genMaxPrimeNumbers_1() {
        assertEquals(1L, PrimeNumberGen.genMaxPrimeNumbers(1));
    }

    @Test
    void test_genMaxPrimeNumbers_2() {
        assertEquals(2L, PrimeNumberGen.genMaxPrimeNumbers(2));
    }

    @Test
    void test_genMaxPrimeNumbers_3() {
        assertEquals(3L, PrimeNumberGen.genMaxPrimeNumbers(3));
    }

    @Test
    void test_genMaxPrimeNumbers_100() {
        assertEquals(97L, PrimeNumberGen.genMaxPrimeNumbers(97));
    }

    @Test
    void test_genMaxPrimeNumbers_Exception() {
        assertThrows(IllegalArgumentException.class, () -> PrimeNumberGen.genMaxPrimeNumbers(0));
    }
}

package net.eugenpaul.mathutils.comp;

public class Algos {
    private Algos() {

    }

    public static long modularExponentiation(long number, long exp, long mod) {
        String expBinary = Long.toBinaryString(exp);

        long response = 1L;
        for (char element : expBinary.toCharArray()) {
            if (element == '0') {
                response = (response * response) % mod;
            } else {
                response = (response * response) % mod;
                response = (response * number) % mod;
            }
        }

        return response;
    }
}

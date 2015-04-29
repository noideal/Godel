package net.noideal.godel;

/**
 * Created by Jesse Daniels on 4/11/2015.
 */
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MathFunction {

    public static Set<Integer> primeFactors(long number) {
        Set<Integer> primefactors = new HashSet<>();
        long copyOfInput = number;

        for (int i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                primefactors.add(i); // prime factor
                copyOfInput /= i;
                i--;
            }
        }
        return primefactors;
    }

    static boolean isPrime(int x) {
        boolean isPrime = true;

        for (int i = 3; i < x / 2; i++) {
            if (x % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
package net.htlgkr.hove.pos3.primzahlen;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EratosthenesPrimeSieve implements PrimeSieve {

    public List<Integer> primesList = new ArrayList<>();
    public int uppercase;


    public EratosthenesPrimeSieve(int uppercase) {
        this.uppercase = uppercase;
    }

    public static void main(String[] args) {
        EratosthenesPrimeSieve eratosthenesPrimeSieve = new EratosthenesPrimeSieve(100);
        eratosthenesPrimeSieve.primeCalculator();
        eratosthenesPrimeSieve.printPrimes();
    }


    public void primeCalculator() {
        boolean[] primesArray = new boolean[uppercase+1];
        primesArray[0] = false;
        primesArray[1] = false;
        for (int i = 2; i < primesArray.length; i++) {
            primesArray[i] = true;
        }
        //mit 2 vervielfachen
        for (int i = 2; i <= primesArray.length / 2; i++) {
            primesArray[i * 2] = false;
        }

        for (int i = 3; i < primesArray.length; i++) {
            if (primesArray[i]) {
                boolean checkIfPrime = isPrime(i);
                primesArray[i] = checkIfPrime;
            }
            //vervielfachen mit zahl
            for (int j = 2; j < primesArray.length / i; j++) {
                primesArray[i * j] = false;
            }

        }
        for (int i = 0; i < primesArray.length; i++) {
            if (primesArray[i]) {
                primesList.add(i);
            }
        }

    }

    @Override
    public boolean isPrime(int p) {
        for (int i = p + 1; i <= uppercase; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printPrimes() {
        System.out.println("The prime nubers are: ");
        System.out.println(primesList);
    }
}

package net.htlgkr.hove.pos3.primzahlen;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EratosthenesPrimeSieve implements PrimeSieve {

    public List<Integer> numberslist = new ArrayList<>();
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

    public void fillingList() {
        for (int i = 2; i <= uppercase; i++) {
            numberslist.add(i);
        }
    }

    public void primeCalculator() {
        boolean array[] = new boolean[uppercase];
        array[0] = false;
        array[1] = false;
        for (int i = 2; i <= array.length; i++) {
            array[i] = true;
        }


        //fillingList();

        /*boolean primeNumber = true;
        for (int i = 1; i <= numberslist.size(); i++) {
            for (int j = 0; j <= numberslist.size(); j++) {
                if(2*j == numberslist.get(i)){
                    primeNumber = false;
                }
            }
            if (primeNumber){
                fillingPrimesList(i);
            }

        }
        for (int i = 2; i <= numberslist.size(); i++) {
            boolean prime = isPrime(3);
            if (prime) {
                for (int j = i; j < numberslist.size(); j++) {
                    if (j % i == 0) {
                        fillingPrimesList(j);
                    }
                }
            }
        }*/
    }

    public void fillingPrimesList(int i) {
       primesList.add(i);
    }

    @Override
    public boolean isPrime(int p) {
        for (int i = p + 1; i <= uppercase; i++) {
            if (p % i == 0) {
                fillingPrimesList(p);
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

package net.htlgkr.hove.pos3.primzahlen;


import java.util.ArrayList;
import java.util.List;

public class EratosthenesPrimeSieve implements PrimeSieve {

    public List<Integer> numberslist = new ArrayList<>();
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
        fillingList();
        for (int i = 2; i < numberslist.size(); i++) {
            boolean prime = isPrime(numberslist.get(i));
            for (int j = i; j < numberslist.size(); j++) {
                if (j % i == 0) {
                    deletingList(j);
                }
            }

        }
    }

    public void deletingList(int i) {
        numberslist.remove(i);
    }

    @Override
    public boolean isPrime(int p) {
        for (int i = p + 1; i < uppercase; i++) {
            if (p % i == 0) {
                deletingList(p);
                return false;
            }
        }
        return true;
    }

    @Override
    public void printPrimes() {
        System.out.println("The prime nubers are: ");
        System.out.println(numberslist);
    }
}

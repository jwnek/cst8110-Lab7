import java.util.Scanner;

public class PrimeNumbers {
	private int[] primes;
	private Scanner input;

	public PrimeNumbers() {
		input = new Scanner(System.in);
	}

	public void getNumberFromUser() {
		System.out.print("How many prime numbers do you want? ");
		int number = input.nextInt();
		while (number < 1) {
			System.out.println("You need to generate at least one prime number");
			number = input.nextInt();
		}
		primes = new int[number];
	}

	public void generatePrimes() {
		primes[0] = 2;
		int primeTotal = 1;
		int primeCandidate = 3;
		while (primeTotal < primes.length) {
			boolean isPrime = true;
			int previousPrime = 0;
			while (previousPrime < primeTotal) {
				if(primeCandidate < primes[previousPrime]*primes[previousPrime]) {
					break;
				} else if ((primeCandidate % primes[previousPrime]) == 0) {
					isPrime = false;
					break;
				}
				previousPrime++;
			}
			if (isPrime) {
				primes[primeTotal] = primeCandidate;
				primeTotal++;
			}
			primeCandidate += 2;
		}
	}

	public void printPrimes() {
		System.out.println("\nThe first " + primes.length + " prime numbers are:");
		for (int i = 0; i < primes.length; i++) {
			System.out.println((i + 1) + "\t" + primes[i]);
		}
	}
}

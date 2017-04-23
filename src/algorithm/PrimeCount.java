package algorithm;

public class PrimeCount {
	public int countPrimes(int n) {
        if (n <= 2) {
        	return 0;
        }
        
        boolean [] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
        	if (!isPrime[i]) {
        		count++;
        		for (int j = 2; i * j < n; j++) {
        			isPrime[i * j] = true;
        		}
        	}
        }
        return count;
    }
	
	
	public static void main(String[] args) {
		PrimeCount primeCount = new PrimeCount();
		System.out.println(primeCount.countPrimes(3));
	}
}

package projectEuler;

import java.math.BigInteger;

//Project Euler 266 - Pseudo Square Root

public class PE266 {
	
	public static boolean isPrime(long num) {
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	public static BigInteger PSR(BigInteger num) {
		BigInteger i = new BigInteger("2322988999999999999999999999999999999");
		while(i.multiply(i).compareTo(num)<=0) {
			i=i.add(new BigInteger("1"));
			//System.out.println(i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		
		BigInteger[] product = new BigInteger[190];
		product[0]=new BigInteger("2");
		int num = 3;
		int index = 1;
		while(num<190 && index<190) {
			if(isPrime(num)==true) {
				String n = Integer.toString(num);
				product[index] = product[index-1].multiply(new BigInteger(n));
				index++;
			}
			num++;
		}
		System.out.println(product[index-1]);
		String n2 = String.format("%.0f",Math.pow(10, 16));
		System.out.println(PSR(product[index-1]));
		//.mod(new BigInteger(n2))
		
		
		//System.out.println(n2);
		//System.out.println(product[index-1].mod(new BigInteger(n2)));
	}

}

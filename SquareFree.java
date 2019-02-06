package projectEuler;


public class SquareFree {
	
	public static final int LIMIT = (int) Math.pow(2,50);

	public static int count = 0;
	
	public static boolean isPrime(int n) {
		if(n<2) return false;
		else if(n==2) return true;
		else {
			for(int i=2;i<=Math.sqrt((double)n);i++) {
				if(n%i==0) return false;
			}
		}
		return true;
	}
	
	public static boolean isSquareFree(int n) {
		for(int i=1;i<=n;i++) {
			if(isPrime(i)&&n%(i*i)==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		for(int i=1; i<LIMIT; i++) {
			if(isSquareFree(i)) count++;
		} 
		System.out.println(count);
		
	}

}

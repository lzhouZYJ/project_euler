package projectEuler;


public class PrimeSummations {
	
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
	
	public static int count = 0;
	
	public static int count(int num) {
		return count(num, num);
	}
	
	public static int count(int num, int max) {
		if(num==0) {
			count++;
			//System.out.println("count:"+count);
		}
		else{
			for(int i=max;i>=1;i--) {
				if(i<=num&&isPrime(i)) {
					//System.out.print(i+"\t");
					count(num-i, i);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		//System.out.println("result:"+count(45));
		
		for(int i=10; i<100; i++) {
			if(count(i)>5000) {
				System.out.println("result:"+i);
				break;
			}
			count=0;
		}
		
		
	}

}

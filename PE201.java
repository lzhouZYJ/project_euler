package projectEuler;
//Proj Euler 201 Subsets with a unique sum

public class PE201 {
	
	public static void main(String[] args) {
		
		//size of subset
		int number = 50;
		
		//total sum of the entire set
		int total = 0;
		for(int i=1; i<=100; i++) {
			total += i*i;
		}
		 
		int[][]  memo = new int[number+1][total+1];
		
		memo[0][0] = 1;
		
		//sum is used to keep track of what cells of the previous row
		//need to be considered when filling out a new row
		int sum = 0;
		
		for(int num=1; num<=100; num++) {
			for(int i=Math.min(num, number); i>=1; i--) {
				for(int k=0; k<=sum; k++) {
					memo[i][k+num*num] += memo[i-1][k];
				}
			}
			sum += num*num;
		}
		
		//find unique sums of 50 nums and add them together
		int result = 0;
		for(int i=0; i<=total; i++) {
			if(memo[number][i]==1) result+=i;
		}
		System.out.println(result);
		
	}

}

//find a consecutive subsequence with the maximum sum

public class MaxSum {
	
	public static int findMax(int[] arr) {
		
		int[] memo = new int[arr.length];
		memo[0]=arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i]+memo[i-1]>arr[i]) memo[i]=arr[i]+memo[i-1];
			else memo[i]=arr[i];
		}
		int max = Integer.MIN_VALUE;
		for(int i : memo) {
			if(i>max) max=i;
		}
		return max;
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {1,2,-4,3,-2,3,-2,4,5,-1};
		System.out.println(findMax(array));
		
	}

}

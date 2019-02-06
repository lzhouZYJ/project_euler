package projectEuler;
//Project euler 76

public class Summations {
	
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
				if(i<=num) {
					//System.out.print(i+"\t");
					count(num-i, i);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int result = count(5)-1;//minus the case with only the num itself
		System.out.println("result:"+result);
		
	}

}

//find the longest substring that is a palindrome

public class LongestPalindrome {
	
	public static boolean isPalindrome(String str) {
		for(int i=0; i<=str.length()/2; i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
		}
		return true;
	}
	
	public static String findPalindrome(String str, int mid) {
		String result = "";
		int start = mid-1;
		int end = mid+1;
		while(start>=0&&end<str.length()&&str.charAt(start)==str.charAt(end)) {
			result=str.substring(start, end+1);
			start--;
			end++;
		}
		return result;
	}
	
	public static String findMaxPalindrome(String str) {
		String result = "";
		int maxLength = 0;
		for(int i=0; i<str.length(); i++) {
			String temp = findPalindrome(str, i);
			if(temp.length()>maxLength) {
				result=temp;
				maxLength = temp.length();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(findMaxPalindrome("asdfasabcdefedcbasasd"));
		
	}

}

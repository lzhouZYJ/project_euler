package projectEuler;
//Project Euler 184 - Triangles containing the origin

public class PE184 {
	
	public static boolean isInTriangle(point[] arr) {
		int x1 = arr[0].x;
		int y1 = arr[0].y;
		int x2 = arr[1].x;
		int y2 = arr[1].y;
		int x3 = arr[2].x;
		int y3 = arr[2].y;
		int area = Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
		int area2 = Math.abs(0*(y2-y3)+x2*(y3-0)+x3*(0-y2));
		int area3 = Math.abs(x1*(0-y3)+0*(y3-y1)+x3*(y1-0));
		int area4 = Math.abs(x1*(y2-0)+x2*(0-y1)+0*(y1-y2));
		if(area2!=0&&area3!=0&&area4!=0&&area==area2+area3+area4) return true;
		return false;
	}
	
	public static int[] memo = new int[106];
	
	public static int findAnswer(int radius) {
		
		if(memo[radius]!=0) return memo[radius];		
		memo[radius]=memo[radius-1];
		int count = 0;
		for(int x=0-radius+1; x<=radius-1; x++) {
			for(int y=radius-1; y<=0-radius+1; y=y-2*radius+2) {
				point[] array = new point[3];
				array[0] = new point(x,y);
				for(int x2=0-radius+1;x2<=radius-1;x2++) {
					for(int y2=0-radius+1;y2<=radius-1;y2++) {
						if(!(x==x2&&y==y2)) {
							array[1] = new point(x2, y2);
							for(int x3=0-radius+1;x3<=radius-1;x3++) {
								for(int y3=0-radius+1;y3<=radius-1;y3++) {
									if(!(x==x3&&y==y3)&&!(x2==x3&&y2==y3)) {
										array[2] = new point(x3,y3);
										if(isInTriangle(array)) count++;
									}
								}
							}
						}
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		//initialize memo values
		memo[0] = 0;
		memo[1] = 0;
		
		
	}

}

class point{
	
	public int x;
	public int y;
	
	public point(int a, int b) {
		x = a;
		y = b;
	}
	
}
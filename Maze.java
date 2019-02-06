package projectEuler;


public class Maze { 
	
	public static boolean valid(int[][] board, int r, int c) {
		if(r<0||c<0||r>=board.length||c>=board[0].length) return false;
		if(board[r][c]==1||board[r][c]==2) return false;
		return true;
	}
	
	public static int[][] convert(String[] board) {
		int[][] result = new int[board.length][board[0].length()];
		char[][] temp = new char[board.length][board[0].length()];
		for(int i=0; i<board.length; i++) {
			temp[i] = board[i].toCharArray();
		}
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[0].length; j++) {
				if(temp[i][j]==' ') {
					result[i][j]=0;	//0 means path
				}
				else {
					result[i][j]=1;	//1 means wall
				}
			}
		}
		return result;
	}
	
	public static int count = 0;
	
	public static int solve(int[][] maze, int srow, int scol, int erow, int ecol) {
		maze[srow][scol]=2;
		for(int[] row : maze) {
			for(int n : row) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
		System.out.println();
		if(srow==erow && scol==ecol){
			count++;
			System.out.println("count:"+count);
			for(int[] row : maze) {
				for(int n : row) {
					System.out.print(n+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		else{
			if(valid(maze,srow+1,scol)&&maze[srow+1][scol]==0) solve(maze,srow+1, scol, erow, ecol);
			if(valid(maze,srow-1,scol)&&maze[srow-1][scol]==0) solve(maze,srow-1, scol, erow, ecol);
			if(valid(maze,srow,scol+1)&&maze[srow][scol+1]==0) {
				solve(maze,srow, scol+1, erow, ecol);
			}
			if(valid(maze,srow,scol-1)&&maze[srow][scol-1]==0) solve(maze,srow, scol-1, erow, ecol);
		}
		maze[srow][scol]=0;
		return count;
	}
	
	public static void main(String[] args) {
		
		String[] maze = 
			{" XX XX XX ",
			 " XX X     ",
			 "      XX X ",
			 "XXXXX     "};
		
		int[][] ma = convert(maze);
		
		System.out.println("result:"+solve(ma, 0,0,3,9));
		
	}

}

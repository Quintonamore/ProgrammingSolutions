import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Grid {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		Cell[][] grid = new Cell[m][n];
		ArrayList<Cell> finished = new ArrayList<Cell>();
		
		for(int i=0; i<m; i++){
			String line = scan.next();
			for(int j=0; j<line.length(); j++){
				String digit = "";
				digit = digit + line.charAt(j);
				int num = Integer.parseInt(digit);
				Cell temp = new Cell(i,j, num);
				grid[i][j] = temp;
			}
		}
		Cell first = grid[0][0];
		Cell last = grid[m-1][n-1];
		Queue<Cell> q = new LinkedList<Cell>();
		q.add(first);
		while(!q.isEmpty()){
			Cell temp = q.poll();
			if(temp.getRow() == m-1 && temp.getCol() == n-1)
				finished.add(temp);
			else{
				int k = temp.getDigit();
				
				for(int i = 0; i < 4; i++) {
					int r = 0, c = 0;
					if(i == 0) {
						r = temp.getRow();
						c = temp.getCol()-k;
					}
					if(i == 1) {
						r = temp.getRow();
						c = temp.getCol()+k;
					}
					if(i == 2) {
						r = temp.getRow()-k;
						c = temp.getCol();
					}
					if(i == 3) {
						r = temp.getRow()+k;
						c = temp.getCol();
					}
					
					if(
						isCell(r, c, m, n) && 
						((temp.numberOfParents() < grid[r][c].numberOfParents()) || !grid[r][c].hasParent()) &&
						!(r == 0 && c == 0)
						) {
							grid[r][c].setParent(temp);
							q.add(grid[r][c]);
					}
				}
			}
			/*
			for(Cell cell : q) {
				System.out.print(cell + ", ");
			} System.out.println("");
			*/
		}
		int min = n*m+1;
		if(finished.size()==0){
			System.out.println("IMPOSSIBLE");
		}
		else{
			for(int i =0; i<finished.size(); i++){
				if(finished.get(i).numberOfParents() < min){
					min = finished.get(i).numberOfParents();
				}
			}
			System.out.println(min);
		}
	}
	
	public static boolean isCell(int r, int c, int m, int n) {
		if(r < 0 || c < 0 || r >= m || c >= n) return false;
		else return true;
	}
	
	public static class Cell{
		int row, col, jump;
		Cell parent = null;
		
		Cell(int r, int c, int j){
			row = r; col = c; jump = j;
		}
		
		int numberOfParents() {
			if(parent != null) return 1+parent.numberOfParents();
			else return 0;
		}
		
		boolean hasParent(){
			if(parent == null)
				return false;
			return true;
		}
		
		Cell getParent(){
			return parent;
		}
		
		Cell(Cell other){
			row = other.row;
			col = other.col;
			jump = other.jump;
		}
		
		void setParent(Cell p){
			parent = p;
		}
		
		int getRow(){
			return row;
		}
		
		int getCol(){
			return col;
		}
		
		int getDigit(){
			return jump;
		}
		
		static boolean isCell(int r, int c){
			if(r >=0 && c>=0)
				return true;
			else
				return false;
		}
		
		@Override
		public boolean equals(Object other){
			if(other instanceof Cell) {
			if(this.row == ((Cell)other).row && this.col == ((Cell)other).col && this.jump == ((Cell)other).jump){
				return true;
			}
			else
				return false;
			} else return false;
		}
		
		@Override
		public String toString() {
			return "("+row+","+col+")";
		}
	}

}

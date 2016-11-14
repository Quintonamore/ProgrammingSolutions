import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int w = scan.nextInt();
		int h = scan.nextInt();
		
		grids i = new grids(w,h);
		
		for(int c = 0; c<w; c++){
			String temp = scan.next();
			for(int d = 0; d<h; d++){
				i.addValue(c, d, temp.charAt(d));
			}
		}
		
		int counter = 0;
		
		for(int c = 0; c<w; c++){
			for(int d = 0; d<h; d++){
				if(i.getTile(c, d).type == 'L' && i.getTile(c, d).visited == false){
					
					i.findConnectedLand(c,d);
					counter++;
					
					
					/*
					if(i.findConnectedLand(c+1, d+1)){
						counter++;
					}
					else if(i.findConnectedLand(c+1, d))
						counter++;
					else if(i.findConnectedLand(c+1, d-1))
						counter++;
					else if(i.findConnectedLand(c, d+1))
						counter++;
					else if(i.findConnectedLand(c, d-1))
						counter++;
					else if(i.findConnectedLand(c-1, d+1))
						counter++;
					else if(i.findConnectedLand(c-1, d))
						counter++;
					else if(i.findConnectedLand(c-1, d-1))
						counter++;
						
						*/
					
					
				}
			}
		}
		
		System.out.println(counter);

	}

}


class grids {
	tile[][] g;
	int numIslands;
	
	
	grids(int i, int j){
		g = new tile[i][j];
		numIslands = 0;
	}
	
	void addValue(int i, int j, char a){
		g[i][j] = new tile(a);
	}
	
	tile getTile(int i, int j){
		if(i < 0 || i >= g.length){
			return new tile('F');
		}
		else if ( j < 0 || j >= g[i].length){
			return new tile('F');
		}
		else{
			return g[i][j];
		}
	}
	
	boolean findConnectedLand(int i, int j){
		
		if(getTile(i,j).visited == true){
			return false;
		}
		else if(getTile(i,j).type == 'W'){
			return false;
		}
		else if(getTile(i,j).type == 'F'){
			return false;
		}
		else if(getTile(i,j).type == 'C'){
			getTile(i,j).visited = true;
			//findConnectedLand(i+1, j+1);
			findConnectedLand(i+1, j);
			//findConnectedLand(i+1, j-1);
			findConnectedLand(i, j+1);
			findConnectedLand(i, j-1);
			//findConnectedLand(i-1, j+1);
			findConnectedLand(i-1, j);
			//findConnectedLand(i-1, j-1);
			return false;
			
		}
		else if(getTile(i,j).type == 'L'){
			getTile(i,j).visited = true;
			//findConnectedLand(i+1, j+1);
			findConnectedLand(i+1, j);
			//findConnectedLand(i+1, j-1);
			findConnectedLand(i, j+1);
			findConnectedLand(i, j-1);
			//findConnectedLand(i-1, j+1);
			findConnectedLand(i-1, j);
			//findConnectedLand(i-1, j-1);
			return true;
			
			
		}
		else{
		return false;
		}
		
	}
}

class tile {
	public char type;
	public boolean visited;
	public boolean connectedToIsland;
	
	tile(char a){
		type = a;
		visited = false;
		connectedToIsland = false;
	}
	
}

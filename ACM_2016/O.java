import java.util.Scanner;

public class O {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		for(int i = 0;i < a; i++){
			for(int j = 0; j < b; j++){
				
			}
		}
		

	}

}


class grid{
	char[][] g;
	public twoints robot;
	public twoints exit;
	public twoints currentPosition;
	
	grid(int i, int j){
		g = new char[i][j];
	}
	
	void inputValue(int i, int j, char a){
		g[i][j] = a;
		if(a == 'R'){
			robot = new twoints(i,j);
			currentPosition = new twoints(i,j);
		}
		if(a == 'E'){
			exit = new twoints(i,j);
		}
	}
	
	
	
	
}
class twoints {
	public int x;
	public int y;
	
	twoints(int l, int r){
		x = l;
		y = r;
	}
	
	
}
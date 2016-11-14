import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		
		char[][] input = new char[rows][cols];
		char[][] output = new char[rows][cols];
		String temp;
		

		
		for(int i=0; i< rows; i++){
			temp = scan.next();
			for(int j=0;j < cols;j++){
				input[i][j]= temp.charAt(j);
				output[i][j] = temp.charAt(j);
			}
		}
		
		boolean flag = false;
		
		while(!flag){
			flag = true;
			for(int i=0; i< rows; i++){
				for(int j=0;j < cols;j++){
					if(i != rows-1){
						if(output[i][j]=='o' && output[i+1][j]=='.'){
							output[i][j]='.';
							output[i+1][j]='o';
							flag=false;
						}
					}
				}
			}
			
		}
		
		for(int i=0; i< rows; i++){
			for(int j=0;j < cols;j++){
				System.out.print(output[i][j]);				
			}
			System.out.println();
		}

	}

}

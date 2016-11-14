import java.util.Scanner;

public class S {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		
		String[][] input = new String[rows][cols];
		String[][] output = new String[rows][cols];
		boolean[][] flag = new boolean[rows][cols];
		String temp;
		
		for(int i=0; i< rows; i++){
			for(int j=0;j < cols;j++){
				temp = scan.next();
				input[i][j]= temp;
				output[i][j] = temp;
				if(input[i][j].equals("#") && i != 0) {
					flag[i-1][j] = true;
				}
				if(i == rows -1){
					flag[i][j] = true; 
				}
			}
		}

		for(int i = 0; i<cols;i++){
			for(int j=0;j< rows;j--){
				if(j != 0 && input[j][i].equals(".") && input[j][i-1].equals("o")){
					output[j][i] = "o";
					output[j][i-1] = ".";
				} else if(input[j][i].equals("#") && flag){
					output[j][i] = "#";
					output[j][i-1] = "o";
				} else if(input[j][i].equals(".") && flag){
					output[j][i] = "o";
					output[j][i-1] = ".";
				}
				else {
					
				}
			}
		}
		for(int i=0; i< rows; i++){
			for(int j=0;j < cols;j++){
				System.out.print(output[i][j]);
			}
			System.out.println;
		}
	}

}

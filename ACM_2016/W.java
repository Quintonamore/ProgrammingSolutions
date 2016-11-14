import java.math.BigInteger;
import java.util.Scanner;

public class W {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double[] first = new double[6];
		double[] second = new double[6];
		double wins = 0;
		double games = 0;
		
		for(int i = 0; i < 6; i++){
			first[i] = scan.nextInt();
		}
		scan.nextLine();
		for(int i = 0; i < 6; i++){
			second[i] = scan.nextInt();
		}
		for (int i = 0; i < 6; i++){
			for(int j= 0;j< 6;j++){
				if (first[i] > second[j]){
					wins++;
					games++;
				}
				if (first[i] < second[j]){
					games++;
				}
				
			}
		}
		
		int i = (int) wins;
		int j = (int) games;
	
		
		String win1 = i + "";
		String game1 = j + "";
		
		BigInteger win = new BigInteger(win1);
		BigInteger game = new BigInteger(game1);
		BigInteger g = win.gcd(game);
		
		double gcd = g.floatValue();
		wins = wins / gcd;
		games = games /gcd;
		double avg = wins/games;
		
		System.out.printf("%.5f",avg);
		System.out.println();
		
		

	}

}

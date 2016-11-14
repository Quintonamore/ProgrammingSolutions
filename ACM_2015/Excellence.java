import java.util.Arrays;
import java.util.Scanner;

public class Excellence {

	public static void main(String[] args) {
		
		/*
		int numCount = (int)(Math.pow(10, 6));
		int[] numArray = new int[numCount];
		for(int i = 0; i < numCount; i++) numArray[i] = i;
		*/
		
		Scanner sc = new Scanner(System.in);
		int numCount = sc.nextInt();
		int[] numArray = new int[numCount];
		for(int i = 0; i < numCount; i++) {
			numArray[i] = sc.nextInt();
		}
		
		Arrays.sort(numArray);
		
		int maxVal = (int)(2*Math.pow(10, 6)+1);
		for(int i = 0; i < (numCount/2); i++) {
			int val = numArray[i] + numArray[numCount-1-i];
			if(val < maxVal) maxVal = val;
		}
		
		System.out.println(maxVal);
	}

}

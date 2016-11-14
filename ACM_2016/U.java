import java.util.Scanner;
import java.util.ArrayList;

public class U {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int colors = scan.nextInt();
		int temp1 = 0,temp2 = 0;
		int max1 = 0, max2 = 0;
		int zeros = 0;
		int matches = 0;
		
		int[] arr = new int[colors];
		
		for(int i = 0; i < colors; i++) {
			arr[i] = scan.nextInt();
		}
		
		 do{
			for(int i = 0; i < colors; i++) {
				if(max1 <= arr[i]) {
					max2 = max1;
					max1 = arr[i];
					temp2 = temp1;
					temp1 = i;
				}
				else if(max2 < arr[i] && arr[i] < max1) {
					max2 = arr[i];
					temp2 = i;
				}
				
			}
			//System.out.println("max1: "+max1 + " max2: "+max2);
			matches += max2;
			max1 = max1 - max2;
			max2 = 0;
			arr[temp1] = max1;
			max1=0;
			arr[temp2] = 0;
			zeros++;
			//System.out.println(zeros);
		
		 } while(zeros != colors - 2 );
		
		System.out.println(matches);
	}

}

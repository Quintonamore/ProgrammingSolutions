import java.util.Scanner;

public class P {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		int r = scan.nextInt();
		
		boolean[] houses = new boolean[n];
		for(int i = 0; i < k; i++){
			int temp = scan.nextInt();
			houses[temp -1] = true;
		}
		
		int counter = r;
		int cameras = 0;
		int neededCameras = 0;
		for(int i = 0; i < n; i++){
			if(counter==0){
				counter = r;
				cameras = 0;
				if(cameras < 2){
					neededCameras++;
				}
			}
			if(houses[i]){
				cameras++;
			}
		}
		

	}

}

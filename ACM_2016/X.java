import java.util.Scanner;

public class X {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		box b1 = new box(scan.nextInt(), scan.nextInt());
		box b2 = new box(scan.nextInt(), scan.nextInt());
		box b3 = new box(scan.nextInt(), scan.nextInt());
		
		int[] sumArray = new int[8];
		
		sumArray[0] = b1.x + b2.x + b3.x;
		sumArray[1] = b1.x + b2.x + b3.y;
		sumArray[2] = b1.x + b2.y + b3.x;
		sumArray[3] = b1.x + b2.y + b3.y;
		sumArray[4] = b1.y + b2.x + b3.x;
		sumArray[5] = b1.y + b2.x + b3.y;
		sumArray[6] = b1.y + b2.y + b3.x;
		sumArray[7] = b1.y + b2.y + b3.y;
		
		boolean hey = false;
		int counter = sumArray.length-1;
		
		for(int i = 0; i < 4; i++){
				if (sumArray[i] == sumArray[counter]){
					//System.out.println(sumArray[i] + " " + sumArray[j] + " " + i + " " + j);
					hey = true;
				}
				counter--;
		}
		
		if(hey){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
		

	}

}


class box {
	public int x;
	public int y;
	
	box(int l, int r){
		x = l;
		y = r;
	}
	
	
}

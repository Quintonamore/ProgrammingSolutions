import java.util.Scanner;

public class R {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		scan.next();
		int b = scan.nextInt();
		scan.next();
		int result = scan.nextInt();
		
		int test = a + b;
		if(test == result){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
			
		}
	}

}

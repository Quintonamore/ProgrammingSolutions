import java.util.Scanner;

public class M {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String s = scan.nextLine();
		
		int lastCharFound = 0;
		int foundLetters = 0;
		
		for(int i = 0; i < 26; i++){
			char find = (char) ('a' + i);
			for(int j = lastCharFound; j < s.length(); j++){
				if(find == s.charAt(j)){
					lastCharFound = j;
					foundLetters++;
					break;
				}
			}
		}
		
		System.out.println(26 - foundLetters);

	}

}

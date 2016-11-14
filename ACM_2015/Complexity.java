import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Complexity {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int erase = 0;
		HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
		ArrayList<Character> charList = new ArrayList<Character>();
		String s = scan.next();
		for(int i =0; i< s.length(); i++){
			if(charMap.containsKey(s.charAt(i))) {
				charMap.put(s.charAt(i), charMap.get(s.charAt(i))+1);
			} else {
				charMap.put(s.charAt(i), 1);
			}
			
			
			if(!charList.contains(s.charAt(i))){
				charList.add(s.charAt(i));
			}
			else{
				erase++;
			}
		}
		/*
		int size = list.size();
		if(size < 2)
			System.out.println(0);
		else if(size == 3)
			System.out.println(1);
		else{
			size = size -2;
			System.out.println(size+erase);
		}
		*/
		
		
		Character cMost1 = 0;
		int iMost1 = 0;
		Character cMost2 = 0;
		int iMost2 = 0;
		
		for(Entry<Character,Integer> entry : charMap.entrySet()) {
			if(entry.getValue() > iMost1) {
				iMost2 = iMost1;
				cMost2 = cMost1;
				iMost1 = entry.getValue();
				cMost1 = entry.getKey();
			} else if(entry.getValue() > iMost2) {
				iMost2 = entry.getValue();
				cMost2 = entry.getKey();
			}
		}
		
		if(charList.size() <= 2) System.out.println(0);
		else {
			int amount = 0;
			for(Character c : charList) {
				if(!(c.equals(cMost1) || c.equals(cMost2))) {
					if(charMap.containsKey(c)) {
						amount += charMap.get(c);
					}
				}
			}
			System.out.println(amount);
		}
	}

}

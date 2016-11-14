import java.util.Arrays;
import java.util.Scanner;

public class Class_Time {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int nameCount = Integer.parseInt(sc.nextLine());
		Name[] names = new Name[nameCount];
		for(int i = 0; i < nameCount; i++) {
			String[] parts = sc.nextLine().split(" ");
			names[i] = new Name(parts[0], parts[1]);
		}
		
		Arrays.sort(names);
		
		for(int i = 0; i < nameCount; i++) {
			System.out.println(names[i]);
		}
	}
	
	public static class Name implements Comparable {
		
		public String firstName;
		public String lastName;
		
		public Name(String first, String last) {
			firstName = first;
			lastName = last;
		}

		@Override
		public int compareTo(Object o) {
			if(o instanceof Name) {
				int c1 = lastName.compareTo(((Name)o).lastName);
				if(c1 != 0) return c1;
				else {
					return firstName.compareTo(((Name)o).firstName);
				}
			} else return 0;
		}
		
		@Override
		public String toString() {
			return firstName + " " + lastName;
		}
		
	}

}

import java.util.Scanner;

public class Egg_Drob {
	
	public static int UNKNOWN = 0;
	public static int SAFE = 1;
	public static int BROKEN = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] partsOriginal = sc.nextLine().split(" ");
		int dropCount = Integer.parseInt(partsOriginal[0]);
		int floorCount = Integer.parseInt(partsOriginal[1]);
		
		int[] floors = new int[floorCount];
		
		for(int i = 0; i < dropCount; i++) {
			String[] parts = sc.nextLine().split(" ");
			int floorNum = Integer.parseInt(parts[0]);
			int status = 0;
			if(parts[1].equals("SAFE")) status = SAFE;
			if(parts[1].equals("BROKEN")) status = BROKEN;
			floors[floorNum-1] = status;
		}
		
		int lastFloorSafe = 1;
		int lastFloorBroken = floorCount;
		for(int i = 0; i < floorCount; i++) {
			if(floors[i] == SAFE) lastFloorSafe = i+1;
		}
		for(int i = floorCount-1; i >= 0; i--) {
			if(floors[i] == BROKEN) lastFloorBroken = i+1;
		}
		
		System.out.println((lastFloorSafe+1) + " " + (lastFloorBroken-1));
	}

}

import java.util.Arrays;
import java.util.Scanner;

public class Surf {
	
	public static int UNKNOWN = -1;
	public static int WORTH = 1;
	public static int NOTWORTH = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int waveCount = Integer.parseInt(sc.nextLine());
		Wave[] waves = new Wave[waveCount];
		for(int i = 0; i < waveCount; i++) {
			String[] parts = sc.nextLine().split(" ");
			waves[i] = new Wave(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
		}
		
		Arrays.sort(waves);
		
		long sum = 0;
		int lastTime = 0;
		for(int i = 0; i < waveCount; i++) {
			if(waves[i].minute < lastTime) continue;
			if(isWorth(waves, i)) {
				sum += waves[i].points;
				lastTime = waves[i].endTime();
			}
		}
		
		System.out.println(sum);
	}
	
	private static boolean isWorth(Wave[] waves, int index) {
		if(waves[index].worth != UNKNOWN) {
			return (waves[index].worth > 0);
		}
		if(index == waves.length-1) return true;
		if(waves[index+1].minute >= (waves[index].endTime())) return true;
		
		int sum = 0;
		int cI = index+1;
		while(true) {
			if(cI < waves.length) {
				if(waves[cI].minute < waves[index].endTime()) {
					if(isWorth(waves, cI)) sum += waves[cI].points;
				}
			} else break;
			cI++;
		}
		
		if(waves[index].points > sum) {
			waves[index].worth = WORTH;
			return true;
		}
		else {
			waves[index].worth = NOTWORTH;
			return false;
		}
	}
	
	public static class Wave implements Comparable {
		public int minute;
		public int points;
		public int wait;
		public int worth = UNKNOWN;
		
		public Wave(int minute, int points, int wait) {
			this.minute = minute;
			this.points = points;
			this.wait = wait;
		}
		
		public int endTime() {
			return minute+wait;
		}

		@Override
		public int compareTo(Object o) {
			if(o instanceof Wave) {
				if(minute > ((Wave)o).minute) return 1;
				if(minute < ((Wave)o).minute) return -1;
				return 0;
			} else return 0;
		}
	}

}

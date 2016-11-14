import java.util.Scanner;

public class Millionaire {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] firstParts = sc.nextLine().split(" ");
		int qCount = Integer.parseInt(firstParts[0]);
		double wealth = Integer.parseInt(firstParts[1]);
		double happiness = 0;
		double unsafeWealth = 0;
		
		for(int i = 0; i < qCount; i++) {
			String[] parts = sc.nextLine().split(" ");
			double probability = Double.parseDouble(parts[1]);
			double reward = Double.parseDouble(parts[2]);
			happiness += getHappiness(probability, reward, wealth);
			unsafeWealth += reward;
			if(parts[0].equals("safe")) {
				wealth += unsafeWealth;
				unsafeWealth = 0;
			}
		}
		
		double requiredReward = getMoneyFromHappiness(wealth, happiness);
		System.out.println(requiredReward);
	}
	
	public static double getHappiness(double probability, double reward, double wealth) {
		return probability * Math.log1p(reward/wealth);
	}
	
	public static double getMoneyFromHappiness(double wealth, double totalHappiness) {
		return wealth * (Math.exp(totalHappiness) - 1);
	}

}

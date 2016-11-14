import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums1 = new int[3];
		int[] nums2 = new int[3];
		
		String[] parts1 = sc.nextLine().split(" ");
		String[] parts2 = sc.nextLine().split(" ");
		
		int biggest1 = 0;
		int bIndex1 = -1;
		int biggest2 = 0;
		int bIndex2 = -1;
		
		for(int i = 0; i < 3; i++) {
			nums1[i] = Integer.parseInt(parts1[i]);
			if(nums1[i] > biggest1) {
				biggest1 = nums1[i];
				bIndex1 = i;
			}
			nums2[i] = Integer.parseInt(parts2[i]);
			if(nums2[i] > biggest2) {
				biggest2 = nums2[i];
				bIndex2 = i;
			}
		}
		
		boolean valid = true;
		for(int i = 0; i < 3; i++) {
			boolean found = false;
			for(int j = 0; j < 3; j++) {
				if(nums1[i] == nums2[j]) {
					found = true;
					break;
				}
			}
			if(!found) valid = false;
		}
		
		int lesser1 = 0;
		int lesser2 = 0;
		int greater1 = 0;
		int greater2 = 0;
		
		for(int i = 0; i < 3; i++) {
			if(i != bIndex1) {
				lesser1 += (nums1[i]*nums1[i]);
			} else greater1 = (nums1[i]*nums1[i]);
			if(i != bIndex2) {
				lesser2 += (nums2[i]*nums2[i]);
			} else greater2 = (nums2[i]*nums2[i]);
		}
		
		if((lesser1 != greater1) || (lesser2 != greater2)) valid = false;
		
		
		if(valid) System.out.println("YES");
		else System.out.println("NO");
	}

}

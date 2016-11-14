
public class Testing {

	public static void main(String[] args) {
		String output = "3000\n";
		for(int i = 0; i < 3000; i++) {
			output += (int)(1000000*Math.random())+" "+(int)(1000000*Math.random())+" "+(int)(1000000*Math.random())+"\n";
			if(i%10000 == 0) System.out.println(i);
		}
		
		System.out.println(output);
	}

}

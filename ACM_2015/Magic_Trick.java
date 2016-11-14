import java.util.ArrayList;
import java.util.Scanner;

public class Magic_Trick {
	
	public static enum OpType {
		ADD, SUB, DIV, MULT;
	}
	
	public static class Operation {
		public OpType op;
		public int num;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		/*
		ArrayList<Double> list = new ArrayList<Double>();
		for(double i=1; i< 101; i++){
			list.add(i);
		}
		*/
		int execution = Integer.parseInt(scan.nextLine());
		Operation[] ops = new Operation[execution];
		for(int i = 0; i < execution; i++) {
			String[] parts = scan.nextLine().split(" ");
			Operation op = new Operation();
			switch(parts[0]) {
			case "ADD": op.op = OpType.ADD; break;
			case "SUBTRACT": op.op = OpType.SUB; break;
			case "DIVIDE": op.op = OpType.DIV; break;
			case "MULTIPLY": op.op = OpType.MULT; break;
			default: break;
			}
			op.num = Integer.parseInt(parts[1]);
			ops[i] = op;
		}
		
		int falseNums = 0;
		
		for(int n = 1; n <= 100; n++) {
			int num = n;
			for(int i = 0; i < execution; i++) {
				boolean failed = false;
				switch(ops[i].op){
				case ADD:
					num = num + ops[i].num;
					break;
				case SUB:
					num = num - ops[i].num;
					if(num < 0) {
						falseNums++;
						failed = true;
						break;
					}
					break;
				case MULT:
					num = num * ops[i].num;
					break;
				case DIV:
					if((num % ops[i].num) != 0) {
						falseNums++;
						failed = true;
						break;
					}
					num = num / ops[i].num;
					break;
				}
				if(failed) break;
			}
		}
		
		System.out.println(falseNums);
		
	}

}

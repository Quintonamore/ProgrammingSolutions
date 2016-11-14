import java.util.ArrayList;
import java.util.Scanner;

public class Blur {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] firstParts = sc.nextLine().split(" ");
		int width = Integer.parseInt(firstParts[0]);
		int height = Integer.parseInt(firstParts[1]);
		int blurTimes = Integer.parseInt(firstParts[2]);
		
		Fraction[][] image = new Fraction[width][height];
		for(int y = 0; y < height; y++) {
			String[] parts = sc.nextLine().split(" ");
			for(int x = 0; x < width; x++) {
				image[x][y] = new Fraction(Integer.parseInt(parts[x]));
			}
		}
		
		for(int i = 0; i < blurTimes; i++) {
			image = getBlurredImage(image, width, height);
		}
		
		ArrayList<Fraction> uniques = new ArrayList<Fraction>();
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				if(!uniques.contains(image[x][y])) uniques.add(image[x][y]);
				//System.out.print(image[x][y]+", ");
			}
		}
		//System.out.println("");
		
		System.out.println(uniques.size());
	}
	
	public static Fraction[][] getBlurredImage(Fraction[][] oldImage, int width, int height) {
		Fraction[][] newImage = new Fraction[width][height];
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				newImage[x][y] = blurValue(oldImage, x, y, width, height);
				//System.out.print(newImage[x][y] + ", ");
			}
		}
		//System.out.println("");
		return newImage;
	}
	
	public static Fraction blurValue(Fraction[][] image, int x, int y, int width, int height) {
		Fraction[] values = new Fraction[9];
		int i = 0;
		for(int xP = x-1; xP < x+2; xP++) {
			for(int yP = y-1; yP < y+2; yP++) {
				int[] coords = getCoordWrap(xP, yP, width, height);
				values[i] = image[coords[0]][coords[1]];
				i++;
			}
		}
		
		Fraction sum = new Fraction(0);
		for(int j = 0; j < 9; j++) sum = sum.add(values[j]);
		//System.out.print(sum+"-");
		return sum.divide(9);
	}
	
	public static int[] getCoordWrap(int x, int y, int width, int height) {
		int[] output = new int[2];
		if(x < 0) output[0] = width-1;
		else if(x > width-1) output[0] = 0;
		else output[0] = x;
		if(y < 0) output[1] = height-1;
		else if(y > height-1) output[1] = 0;
		else output[1] = y;
		return output;
	}
	
	public static class Fraction {
		int numerator;
		int denominator;
		
		public Fraction(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
		
		public Fraction(int numerator) {
			this.numerator = numerator;
			this.denominator = 1;
		}
		
		public Fraction reduce() {
			if((numerator % 2 == 0) && (denominator % 2 == 0)) {
				numerator /= 2;
				denominator /= 2;
				return reduce();
			} else if((numerator % 3 == 0) && (denominator % 3 == 0)) {
				numerator /= 3;
				denominator /= 3;
				return reduce();
			}
			
			return this;
		}
		
		public Fraction add(Fraction other) {
			Fraction fract = new Fraction(numerator*other.denominator + other.numerator*denominator, denominator*other.denominator);
			fract.reduce();
			return fract;
		}
		
		public Fraction multiply(Fraction other) {
			return new Fraction(numerator*other.numerator, denominator*other.denominator).reduce();
		}
		
		public Fraction inverse() {
			return new Fraction(denominator, numerator).reduce();
		}
		
		public Fraction divide(Fraction other) {
			return multiply(other.inverse()).reduce();
		}
		
		public Fraction divide(int num) {
			return multiply(new Fraction(num).inverse()).reduce();
		}
		
		@Override
		public boolean equals(Object other) {
			if(other instanceof Fraction) {
				reduce();
				((Fraction) other).reduce();
				return (numerator == ((Fraction) other).numerator && denominator == ((Fraction) other).denominator);
			} else return false;
		}
	}

}

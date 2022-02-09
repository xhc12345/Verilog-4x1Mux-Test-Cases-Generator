import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//*********************************************************
		int numCases = 64;	// number of test cases to be generated
		//*********************************************************
		
		int maxDigits = getMaxDigit(numCases);
		for(int i=0; i<numCases; i++) {
			System.out.println(generate(i, maxDigits));
		}
	}
	
	private static int getMaxDigit(int n) {
		String nButStr = n+"";
		return nButStr.length();
	}
	
	private static int[] decimalToBinary(int n) {
		String b = Integer.toBinaryString(n);
		if(b.length()>6)
			System.out.println("Attempted to generate illegal test case "+n);
		else {
			int rem = 6-b.length();
			String pad = "";
			for(int i=0; i<rem; i++) {
				pad += "0";
			}
			b = pad + b;
		}
		//System.out.println(Arrays.toString(v));
		int[] ret = new int[b.length()];
		for(int i=0; i<b.length(); i++) {
			ret[i] = Character.getNumericValue(b.charAt(i));
		}
		return ret;
	}
	
	public static int muxExpects(int[] v) {
		int s1 = v[4];
		int s0 = v[5];
		int i = s1 * 2 + s0 * 1;
		return v[i];
	}
	
	public static TestCase generate(int n, int digits) {
		
		ArrayList<StrValPair> inputs = new ArrayList<StrValPair>();
		int[] v = decimalToBinary(n);
		inputs.add(new StrValPair("i0", v[0]));
		inputs.add(new StrValPair("i1", v[1]));
		inputs.add(new StrValPair("i2", v[2]));
		inputs.add(new StrValPair("i3", v[3]));
		inputs.add(new StrValPair("s1", v[4]));
		inputs.add(new StrValPair("s0", v[5]));
		String name = "TC" + String.format("%0"+digits+"d", n+1);
		TestCase Case = new TestCase(inputs, muxExpects(v), name, 50, "d", 4);
		return Case;
	}
}

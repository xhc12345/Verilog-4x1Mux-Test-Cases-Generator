
public class StrValPair {
	private String name;
	private int value;
	
	public StrValPair(String n, int v) {
		name = n;
		value = v==0? 0:1;
	}
	
	public void toggle() {
		value = value==0? 1:0;
	}
	
	@Override
	public String toString() {
		return name+" = "+value+"; ";
	}
	
	public String toString2() {
		return name+"="+value;
	}
}

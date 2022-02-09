import java.util.ArrayList;


public class TestCase {
	private ArrayList<StrValPair> inputs;
	private int expect;
	private int numInputs;
	private String caseName;
	private int delayTime;
	private String ifConditionVar;
	private int retAt;
	
	public TestCase(ArrayList<StrValPair> inputs, int expect, String caseName, int delayTime, String ifConditionVar) {
		this.inputs = inputs;
		numInputs = this.inputs.size();
		this.expect = expect;
		this.caseName = caseName;
		this.delayTime = delayTime;
		this.ifConditionVar = ifConditionVar;
		retAt = -2;
	}
	
	public TestCase(ArrayList<StrValPair> inputs, int expect, String caseName, int delayTime, String ifConditionVar, int retAt) {
		this.inputs = inputs;
		numInputs = this.inputs.size();
		this.expect = expect;
		this.caseName = caseName;
		this.delayTime = delayTime;
		this.ifConditionVar = ifConditionVar;
		this.retAt = retAt;
	}
	
	private String inputsToString() {
		String ret = "";
		for(int j=0; j<numInputs; j++) {
			StrValPair i = inputs.get(j);
			ret += i.toString2();
			if(j==numInputs-1) {
				break;
			}
			ret += ", ";
		}
		return ret;
	}
	
	@Override
	public String toString() {
		String ret = "";
		for(int i=0; i<numInputs; i++) {
			StrValPair in = inputs.get(i);
			ret += in.toString();
			if(i==retAt-1)	ret += "\n";
		}
		ret += "\n";
		ret += "#"+delayTime+";\n";
		ret += "$display(\""+caseName+"\");\n";
		ret += "if( "+ifConditionVar+" != 1'b"+expect+" ) $display(\""+caseName+" has error, inputs: "+inputsToString()+"\");\n";
		return ret;
	}
}

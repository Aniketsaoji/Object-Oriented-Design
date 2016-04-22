package hw.hw8;

public class BeginField implements State{
	private CSVMachine csvmachine;
	
	public BeginField(CSVMachine csvmachine){
		this.csvmachine = csvmachine;
	}

	public void seeAComma() {
//		System.out.println("Changing state to UnquotedField");
		csvmachine.setState(csvmachine.getUnquotedField());
	}

	public void seeQuotes() {
//		System.out.println("Changing state to QuotedField");
		csvmachine.setState(csvmachine.getQuotedField());
	}

	public void seeOther(char c) {
//		System.out.println("Changing state to UnquotedField");
		csvmachine.add(String.valueOf(c));
		csvmachine.setState(csvmachine.getUnquotedField());
	}
}

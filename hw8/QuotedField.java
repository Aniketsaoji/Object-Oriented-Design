package hw.hw8;

public class QuotedField implements State{
	private CSVMachine csvmachine;
	
	public QuotedField(CSVMachine csvmachine){
		this.csvmachine = csvmachine;
	}
	
	public void seeAComma() {
//		System.out.println("Within quoted field, adding a comma");
		csvmachine.add(",");
	}

	public void seeQuotes() {
//		System.out.println("Changing state to QuotedField");
		csvmachine.setState(csvmachine.getSeenAQuote());
	}

	public void seeOther(char c) {
//		System.out.println("Changing state to UnquotedField");
		csvmachine.add(String.valueOf(c));
	}
}

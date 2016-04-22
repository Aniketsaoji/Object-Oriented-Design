package hw.hw8;

public class SeenAQuote implements State {
	private CSVMachine csvmachine;
	
	public SeenAQuote(CSVMachine csvmachine){
		this.csvmachine = csvmachine;
	}
	
	public void seeAComma(){
//		System.out.println("Changing state to begin and adding line to final list");
		csvmachine.setState(csvmachine.getBeginField());
		csvmachine.nextWord();
	}
	
	public void seeQuotes(){
//		System.out.println("Changing state to QuotedField");
		csvmachine.add(String.valueOf('"'));
		csvmachine.setState(csvmachine.getQuotedField());
	}
	
	public void seeOther(char c){
//		System.out.println("Changing state to Error");
		csvmachine.setState(csvmachine.getError());
	}
}

package hw.hw8;

public class UnquotedField implements State {
	private CSVMachine csvmachine;
	
	public UnquotedField(CSVMachine csvmachine){
		this.csvmachine = csvmachine;
	}
	
	public void seeAComma(){
//		System.out.println("Changing state to begin and adding line to final list");
		csvmachine.setState(csvmachine.getBeginField());
		csvmachine.nextWord();
	}
	
	public void seeQuotes(){
//		System.out.println("Changing state to error");
		csvmachine.setState(csvmachine.getError());
	}
	
	public void seeOther(char c){
//		System.out.println("Adding character to temp list");
		csvmachine.add(String.valueOf(c));
	}

}

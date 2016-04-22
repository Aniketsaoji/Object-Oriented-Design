package hw.hw8;

public class Error implements State {
	private CSVMachine csvmachine;
	
	public Error(CSVMachine csvmachine){
		this.csvmachine = csvmachine;
	}
	
	public void seeAComma(){
//		System.out.println("Changing state to begin and adding line to final list");
		csvmachine.setState(csvmachine.getBeginField());
		csvmachine.nextWord();
	}
	
	public void seeQuotes(){
		csvmachine.remove();
		csvmachine.add("ERROR");
	}

	public void seeOther(char c){
		csvmachine.remove();
		csvmachine.add("ERROR");
	}
}

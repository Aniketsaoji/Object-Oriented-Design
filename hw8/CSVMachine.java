package hw.hw8;

import java.util.ArrayList;
import java.util.List;

public class CSVMachine {
	private List<String> temp = new ArrayList<String>();
	private List<String> output = new ArrayList<String>();
	private State BeginField;
	private State Error;
	private State QuotedField;
	private State SeenAQuote;
	private State UnquotedField;
	
	private State state;
	
	public CSVMachine(){
		BeginField = new BeginField(this);
		Error = new Error(this);
		QuotedField = new QuotedField(this);
		SeenAQuote = new SeenAQuote(this);
		UnquotedField = new UnquotedField(this);
		
		this.state = BeginField;
	}

	public List<String> getRow() {
		String thestring = "";
		for(String s : temp){
			thestring += s;
		}
		output.add(thestring);
		temp = new ArrayList<String>();
		return output;
	}

	public void processChar(char c){
//		System.out.println("Evaluating " + c);
		if(c == ','){
			state.seeAComma();
		}
		else if(c == '"'){
			state.seeQuotes();
		}
		else{
			state.seeOther(c);
		}
	}
	
	public void add(String string){
		temp.add(string);
	}
	
	public void remove(){
		String current;
		int counter;
		if(temp.size()>0){
			counter = temp.size()-1;
		}
		else{
			counter = 0;
		}
		current = temp.get(counter);
		while(current != " "){
			temp.remove(counter);
			counter--;
			current = temp.get(counter);
		}
		
	}
	
	public void nextWord(){
		temp.add(" ");
		state = BeginField;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
//		System.out.println("Changed state to " + state.getClass());
	}

	public State getBeginField() {
		return BeginField;
	}

	public State getError() {
		return Error;
	}

	public State getQuotedField() {
		return QuotedField;
	}

	public State getSeenAQuote() {
		return SeenAQuote;
	}

	public State getUnquotedField() {
		return UnquotedField;
	}

}

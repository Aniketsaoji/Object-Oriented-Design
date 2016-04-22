package hw.hw3;

public class Uniform implements ItemDistribution{
	private int distSize;
	
	public Uniform(int distSize){
		this.distSize = distSize;
	}
	
	public int calculate(){
		int n = (int) (Math.random() * distSize);
		return n;
	}

}

package hw.hw3;

import java.util.Random;

public class Bimodal implements ItemDistribution{
	private int distSize;
	
	public Bimodal(int distSize){
		this.distSize = distSize;
	}
	
	public int calculate(){
		int result = 0;
		int min1 = 1;
		int max1 = 2;
		Random r = new Random();
		int i1 = r.nextInt(max1 - min1 + 1) + min1;
		
		if(i1 == 1){
			int min = 1;
			int max = distSize/4;

			Random r2 = new Random();
			int i2 = r2.nextInt(max - min + 1) + min;
			result = i2;
		}
		
		else if(i1 == 2){
			int min = 3*distSize/4;
			int max = distSize;

			Random r2 = new Random();
			int i2 = r.nextInt(max - min + 1) + min;
			result = i2;
		}
		
		return result;
	}

}

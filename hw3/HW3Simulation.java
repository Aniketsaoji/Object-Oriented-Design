package hw.hw3;

import javax.swing.JOptionPane;

public class HW3Simulation {
	private static final int SIMULATION_TIME = 10000;  // A simulation is for 10,000 seconds.

	public static void main(String[] args) {
		String NCashier = JOptionPane.showInputDialog("Enter the number of normal cashiers");
        String[] NCashiers = NCashier.split(" ");
        String thenormal = NCashiers[0];
        int normal = Integer.parseInt(thenormal);       // get from user
        
        String FCashier = JOptionPane.showInputDialog("Enter the number of fast cashiers");
        String[] FCashiers = FCashier.split(" ");
        String thefast = FCashiers[0];
        int fast   = Integer.parseInt(thefast);       // get from user
        
		String dtype = JOptionPane.showInputDialog("Enter distribution type: uniform or bimodal");
	    String[] dtypes = dtype.split(" ");
	    String distType = dtypes[0];  // get from user
	    
	    String dsize = JOptionPane.showInputDialog("Enter the size of the distribution");
        String[] dsizes = dsize.split(" ");
        String thedist = dsizes[0];
        int distSize = Integer.parseInt(thedist);     // get from user
        
        ItemDistribution id;
		if (distType.equals("uniform")){
			id = new Uniform(distSize);
		}
		else{
			id = new Bimodal(distSize);
		}
		DiningHall hall = new DiningHall(normal, fast, id);
		
		for (int t=0; t<SIMULATION_TIME; t++) 
			hall.elapseOneSecond(t);

		hall.printStatistics();
	}
}

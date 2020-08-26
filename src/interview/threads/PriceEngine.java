package interview.threads;

import java.util.Arrays;

public class PriceEngine {

	public static void main(String[] args) {
		
		
		
		try {
			System.out.println(" start ");
			CycleStoreService cycleStoreService=new CycleStoreService();
			
			
			Cycle[] cycles = cycleStoreService.loadCycles();
			
			System.out.println(" before calculating prices ");
			System.out.println(Arrays.toString(cycles));

			
			
			
			cycleStoreService.calculatePrices(cycles);
			

			
			System.out.println(" calculation is done ");
			System.out.println(Arrays.toString(cycles));
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}

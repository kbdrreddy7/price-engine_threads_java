package com.uttara.interview;

public class Q3 {

	public static void main(String[] args) {
		
						 //    0,1
			 int[] gasAmount= {0,2,4,5}; // gas available at the station i
		int[] fuelCosumption= {2,2,5,4}; // gas required to go next station i+1
				
		
		
		//  int minIndex=
		
		/*
	eg:1
	  stations      ={0,1}
	  gasAmount		={1,2}
	  fuelCosumption={2,1}
	  
	  ---output: 1  if we start from station 1 we can complete the cycle
	  
	  eg:2
		 
		stations  	={0,1,2,3}
		gasAmount 	={0,2,4,5}
     fuelCosumption ={2,2,3,4}
		  
		  ---output :1
		  
		  explanation:   
		  if we start  from station '1'  
		          fuel=4
		          afterGoing next station 4-3=1
		  
	eg:3
   	  stations  	={0,1,2,3}
	gasAmount 		={0,2,4,5}
 	fuelCosumption 	={2,2,5,4}
 	
 	   output:-1
		  
		 */
		
		
		int res=fuelCarProblem(gasAmount,fuelCosumption);
		
		System.out.println(" res "+res);
		
		
	}

	public static int fuelCarProblem(int[] gasAmount, int[] fuelCosumption) {
	
		 // gasAmount.length=fuelCosumption.length= no of stations
		
		
		if(gasAmount.length==0 || fuelCosumption.length==0)
			throw new IllegalArgumentException();
		
		Station startingStation=new Station(0,gasAmount[0], fuelCosumption[0]);
		
		// linking all stations(circular linked list)
		Station currentStation=startingStation;
		for(int i=1; i<gasAmount.length; i++)
		{
			currentStation.nextStation=new Station(i,gasAmount[i], fuelCosumption[i]);
			currentStation=currentStation.nextStation;
		}
		currentStation.nextStation=startingStation;
		
		
		
		int leastStationNo=gasAmount.length; // any max no 
		
		
		// checking one station after another--> weather complete round(journey) is possible
		while(true) {
			
			if(isTravelPossible(startingStation)&&startingStation.stationNo<leastStationNo)
				  leastStationNo=startingStation.stationNo;
			
			startingStation=startingStation.nextStation;
			
			if(startingStation.stationNo==0)
				break; // testing all stations is completed
				 
				
		}
		
		
		return leastStationNo==gasAmount.length?-1:leastStationNo;
	}
	
	public static boolean isTravelPossible (Station startingStation) {
		
		int carFuel=startingStation.fuelAvaialbe;
		
		Station currentStation=startingStation;
		
		while(true) {
			
			
			// if we can go next station->move to next station
			if(carFuel-currentStation.fuelCostToNextStation>0)
			{
				carFuel=carFuel-currentStation.fuelCostToNextStation; // fuel decreased
				
				
				currentStation=currentStation.nextStation;
				carFuel=carFuel+currentStation.fuelAvaialbe;
			}else {
				return false;
			}
			
			// if the next station is starting station--> traveling is completed
			if(currentStation.nextStation.stationNo==startingStation.stationNo)
				 return true;
			
		}
		
	}
	
	
	
}


class Station{
	int fuelAvaialbe;
	int fuelCostToNextStation;
	int stationNo;
	
	Station  nextStation;
	
	public Station(int stationNo,int fuelAvaialbe, int fuelCostToNextStation) {
		super();
		this.stationNo=stationNo;
		this.fuelAvaialbe = fuelAvaialbe;
		this.fuelCostToNextStation = fuelCostToNextStation;
	}
	
	
	
}

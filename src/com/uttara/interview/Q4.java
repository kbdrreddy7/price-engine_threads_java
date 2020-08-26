package com.uttara.interview;

public class Q4 
{ 
	
	static int minSequence(int arr[],  int n) 
	{ 
		int minLength = arr.length; 
		
		boolean found=false;

		for (int i = 0; i < arr.length; i++) 
		{ 
			int sum = arr[i]; 

			if (sum > n) 
				return 1; 

			for (int j = i + 1; j < arr.length; j++) 
			{ 
				sum += arr[j]; 

				if(sum>=n)
				{
					found=true;
					
					if((j-i+1)<minLength) // j-i+1 is the sub array length
						minLength=j-i+1;
				}

			} 
		} 
		return found?minLength:-1; 
	} 

	public static void main(String[] args) 
	{ 
		
		
		/*
		 	Input: arr[] = {2, 3, 1, 5, 6, 3, 7, 9, 14, 10, 2, 5}, K = 35
			Output: 4
			Smallest subsequence with the sum greater than or equal to the given sum K is {7, 9, 14, 10}
			Input: arr[] = {1, 2, 2, 2, 3, 4, 5, 4, 7, 6, 5, 12}, K = 70
			Output:-1
			Subsequence with sum greater than equal to the given sum is not possible.
		 * */
		
		int arr[] = {1, 2, 2, 2, 3, 4, 5, 4, 7, 6, 5, 12}; 
		int k = 70; 
		int res = minSequence(arr, k); 
		System.out.println("res "+res);

	} 
} 


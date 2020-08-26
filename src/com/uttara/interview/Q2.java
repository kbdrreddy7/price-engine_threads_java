package com.uttara.interview;

import java.util.Arrays;

public class Q2 {

	
	
	public static void main(String[] args) {
		
		
		/*
		 Example Input & Output:
		Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
		Output: 3 3 4 5 5 5 6
		
		Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
		Output: 10 10 10 15 15 90 90
		 */
		
		int[] arr= {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};// 3 3 4 5 5 5 6
		int n=4;
		
		int[] res=maxSubArray(arr,n);
		
		System.out.println(Arrays.toString(res));

	}
	
	
	public static int[] maxSubArray(int[] arr, int n) {
		
		int[] res=new int[arr.length-n+1];
		
		
		for(int i=0; i<res.length; i++) 
		{
			int max= findMax(arr,i,i+n);
			
			res[i]=max;
		}
		
		return res;
	}


	private static int findMax(int[] res, int from, int to) {
		
		
		if(res.length==0 || from<0 || to<0 || from>res.length || to>res.length)
			 throw new IllegalArgumentException();
		
		
		int max=res[from];
		
		for(int i=from; i<to; i++) 
		{
		
			if(res[i]>max)
			max=res[i];
		}
	
		
		
		return max;
	}
	
	
	
	
}

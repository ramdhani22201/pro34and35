package testDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicateValuefromArray {

	public static void main(String[] args) {
		int []arr = {2,3,4,5,2,5,2,5,6};
//		int intArrayL = arr.length;
//		
//		int []temp = new int[intArrayL+1];
//		for(int i = 0; i<arr.length; i++)
//		{
//			for(int j=i+1; j<arr.length; j++)
//			{
//				if(arr[i] == arr[j])
//				{
//					
//					
//				}
//				else
//				{
//					temp[i] = arr[i];
//					System.out.println(Arrays.toString(temp));
//				}
//				
//			}
//		 
//		}
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int i : arr)
		{
			hashSet.add(i);
			
		}
		System.out.println(hashSet.toString());
		
	}

}

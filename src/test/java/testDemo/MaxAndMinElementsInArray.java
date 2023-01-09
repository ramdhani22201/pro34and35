package testDemo;

public class MaxAndMinElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,4,40,5,3,87,78};
		int max = arr[0];
		int min = arr[0];
		
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
			}
		}
		System.out.println("Maximam Value   = "+max);
		
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i]< min)
			{
				min = arr[i];
			}
		}
		System.out.println("Minimam Value   = "+min);
		
	}

}

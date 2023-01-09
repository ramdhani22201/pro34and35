package testDemo;

public class Check30ElementIsAvailable {
	public static void main(String args [])
	{
		int arr[] = {13,45,2,4,30,45,};
		int searchEle =30;
		boolean flag = false;
		for(int i=0; i<arr.length; i++)			
		{
			if(arr[i] == searchEle)
			{
				System.out.println(" 30 is duplicate number  = " +i);
				flag = true;
			}
		}
		if(flag == false)
		{
			System.out.println("Element not found");
		}
		
	}

}

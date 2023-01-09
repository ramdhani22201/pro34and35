package testDemo;

import java.util.HashSet;

public class DuplicateElementInArray {

	public static void main(String[] args) {
//Using with loop
		System.out.println("=======Check duplicat value in Array String Using loops========");
		String arr[] = {"java","C","C++","Python","java"};
		boolean flag = false;
		for(int i = 0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[i] == arr[j])
				{
					System.out.println("Found duplicate element = "+ arr[i] +"  and  "+arr[j]);
					flag = true;
				}
			}
		}
		if(flag == false)
		{
			System.out.println("Douplicat element not found");
		}
//Using collection HashSet
		String arr1[] = {"java","C","C++","Python","java"};
		System.out.println("==========Using HashSet ===========");
		HashSet<String>  hashSet = new HashSet<String>();// duplicate value not allow in Set
		for(String str : arr1)
		{
			if(hashSet.add(str) == false)
			{
				System.out.println("there is duplicate value");
			}
		}
		
	}

}
